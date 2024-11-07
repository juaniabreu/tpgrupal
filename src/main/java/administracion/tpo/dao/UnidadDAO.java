package administracion.tpo.dao;

import administracion.tpo.modelo.Reclamo;
import administracion.tpo.modelo.Unidad;
import administracion.tpo.repository.IRepositoryReclamo;
import administracion.tpo.repository.IRepositoryUnidad;

import java.util.List;
import java.util.Optional;

public class UnidadDAO {
    private static UnidadDAO instance;



    private UnidadDAO(){
    }

    public static UnidadDAO getInstance() {
        if(instance==null){
            instance = new UnidadDAO();
        }
        return instance;
    }

    public List<Unidad> getAll(IRepositoryUnidad iRepositoryUnidad){
        return iRepositoryUnidad.findAll();
    }
    public Optional<Unidad> getById(int numero, IRepositoryUnidad iRepositoryUnidad){
        return iRepositoryUnidad.findById(numero);
    }

    public void save(Unidad unidad, IRepositoryUnidad iRepositoryUnidad){
        iRepositoryUnidad.save(unidad);
    }

    public void delete(Unidad unidad, IRepositoryUnidad iRepositoryUnidad){
        iRepositoryUnidad.delete(unidad);
    }
    
    public void update(Unidad unidad, IRepositoryUnidad iRepositoryUnidad){
        if (iRepositoryUnidad.existsById(unidad.getId())) {
        	iRepositoryUnidad.save(unidad);
        }
    }


}
