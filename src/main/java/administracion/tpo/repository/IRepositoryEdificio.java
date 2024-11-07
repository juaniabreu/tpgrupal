package administracion.tpo.repository;

import administracion.tpo.modelo.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryEdificio extends JpaRepository<Edificio, Integer> {
}