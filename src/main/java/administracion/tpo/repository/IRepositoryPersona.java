package administracion.tpo.repository;

import administracion.tpo.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IRepositoryPersona extends JpaRepository<Persona, String> {
    @Query("SELECT p FROM Persona p WHERE p.nombre = :nombre")
    Optional<Persona> findByNombre(String nombre);
}
