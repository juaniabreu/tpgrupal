package administracion.tpo.controller;


import administracion.tpo.dao.PersonaDAO;
import administracion.tpo.modelo.Persona;
import administracion.tpo.repository.IRepositoryPersona;
import administracion.tpo.views.PersonaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private IRepositoryPersona repositoryPersona;

    @PostMapping("/crear")
    public ResponseEntity<PersonaView> createUser(@RequestBody Persona persona) {

        PersonaDAO.getInstance().save(persona, repositoryPersona);
        return ResponseEntity.ok(persona.toView());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<PersonaView> getUser(@PathVariable String nombre) {
        Persona persona = PersonaDAO.getInstance().getByNombre(nombre, repositoryPersona).orElseThrow();
        return ResponseEntity.ok(persona.toView());
    }
}