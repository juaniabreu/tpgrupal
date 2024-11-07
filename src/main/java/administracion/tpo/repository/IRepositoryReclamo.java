package administracion.tpo.repository;

import administracion.tpo.modelo.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepositoryReclamo extends JpaRepository<Reclamo,Integer> {
    @Query("SELECT r FROM Reclamo r WHERE r.edificio.codigo = :codigo")
    public List<Reclamo> findByEdificio(int codigo);

    @Query("SELECT r FROM Reclamo r WHERE r.unidad.id = :id")
    public List<Reclamo> findByUnidad(int id);
}
