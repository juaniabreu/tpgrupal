package administracion.tpo.repository;

import administracion.tpo.modelo.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface IRepositoryImagen extends JpaRepository<Imagen,Integer> {

}
