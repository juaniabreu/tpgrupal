package administracion.tpo.controller;

import administracion.tpo.dao.ImagenDAO;
import administracion.tpo.dao.ReclamoDAO;
import administracion.tpo.dao.UnidadDAO;
import administracion.tpo.modelo.Imagen;
import administracion.tpo.modelo.Reclamo;
import administracion.tpo.modelo.Unidad;
import administracion.tpo.repository.IRepositoryImagen;
import administracion.tpo.repository.IRepositoryReclamo;
import administracion.tpo.repository.IRepositoryUnidad;
import administracion.tpo.views.ReclamoView;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("api/reclamos")
public class ReclamoController {
    @Autowired
    IRepositoryReclamo repositoryReclamo;
    @Autowired
    IRepositoryUnidad repositoryUnidad;
    @Autowired
    IRepositoryImagen repositoryImagen;
    private final String uploadDir = "uploads/";
@PostMapping
public ResponseEntity<ReclamoView> generarReclamo(@RequestBody Reclamo reclamo) {
    Unidad unidad = UnidadDAO.getInstance().getById(reclamo.getUnidad().getId(), repositoryUnidad).orElseThrow();

    if (!unidad.estaHabitado() && reclamo.getUsuario().equals(unidad.getDuenios())) {
        throw new RuntimeException("La unidad no esta habitada, solamente el dueño puede hacer el reclamo");
    } else if (unidad.estaHabitado() && (reclamo.getUsuario().equals(unidad.getInquilinos()) || reclamo.getUsuario().equals(unidad.getDuenios()))) {
        throw new RuntimeException("La unidad esta habitada, solamente el inquilino o el dueño puede hacer el reclamo");
    } else {
        ReclamoDAO.getInstance().save(reclamo, repositoryReclamo);
    }
    return ResponseEntity.ok(reclamo.toView());
}

    // recibimos el id como parametro en la url, para edificio y para unidad.
    @GetMapping("/edificio/{id}")
    public ResponseEntity<List<ReclamoView>> getReclamosPorEdificio (@PathVariable("id") int idEdificio){
        List<Reclamo> reclamos = ReclamoDAO.getInstance().getByEdificio(idEdificio,repositoryReclamo);
        return ResponseEntity.ok(reclamos.stream().map(Reclamo::toView).toList());
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity<List<ReclamoView>> getReclamosPorUnidad (@PathVariable("id") int idUnidad){
        List<Reclamo> reclamos = ReclamoDAO.getInstance().getByUnidad(idUnidad, repositoryReclamo);
        return ResponseEntity.ok(reclamos.stream().map(Reclamo::toView).toList());
    }

    /// reveer esto, no se si esta bien
    @PostMapping("/{id}/imagenes")
    public ResponseEntity<String> cargarImagen(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty");
            }

            String fileName = file.getOriginalFilename();
            Path path = Paths.get(uploadDir + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());

            Imagen imagen = new Imagen(fileName, file.getContentType());
            Reclamo reclamo = ReclamoDAO.getInstance().getById(id, repositoryReclamo).orElseThrow();
            reclamo.agregarImagen(imagen.getDireccion(), imagen.getTipo());
            ImagenDAO.getInstance().save(imagen, repositoryImagen);

            return ResponseEntity.ok("Image uploaded successfully: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al subir la imagen: " + e.getMessage());
        }
    }

}
