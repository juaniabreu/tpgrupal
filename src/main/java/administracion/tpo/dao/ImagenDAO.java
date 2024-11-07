package administracion.tpo.dao;

import administracion.tpo.modelo.Edificio;
import administracion.tpo.modelo.Imagen;
import administracion.tpo.repository.IRepositoryEdificio;
import administracion.tpo.repository.IRepositoryImagen;

import java.util.List;
import java.util.Optional;

public class ImagenDAO {

    private static ImagenDAO instance;

    private ImagenDAO(){

    }

    public static ImagenDAO getInstance() {
        if(instance==null){
            instance = new ImagenDAO();
        }
        return instance;
    }

    public List<Imagen> getAll(IRepositoryImagen iRepositoryImagen){
        return iRepositoryImagen.findAll();
    }
    public Optional<Imagen> getById(int numero, IRepositoryImagen iRepositoryImagen){
        return iRepositoryImagen.findById(numero);
    }

    public void save(Imagen imagen, IRepositoryImagen iRepositoryImagen){
        iRepositoryImagen.save(imagen);
    }

    public void delete(int numero, IRepositoryImagen iRepositoryImagen){
        iRepositoryImagen.deleteById(numero);
    }
    
    public void update(Imagen im, IRepositoryImagen iRepositoryImagen){
        if (iRepositoryImagen.existsById(im.getNumero())) {
        	iRepositoryImagen.save(im);
        }
    }

}
