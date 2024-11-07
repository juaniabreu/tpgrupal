package administracion.tpo.dao;


import administracion.tpo.modelo.Imagen;
import administracion.tpo.modelo.Reclamo;
import administracion.tpo.repository.IRepositoryImagen;
import administracion.tpo.repository.IRepositoryReclamo;

import java.util.List;
import java.util.Optional;

public class ReclamoDAO {
    private static ReclamoDAO instance;


    private ReclamoDAO() {
    }

    public static ReclamoDAO getInstance() {
        if (instance == null) {
            instance = new ReclamoDAO();
        }
        return instance;
    }
    public List<Reclamo> getAll(IRepositoryReclamo iRepositoryReclamo){
        return iRepositoryReclamo.findAll();
    }
    public Optional<Reclamo> getById(int numero, IRepositoryReclamo iRepositoryReclamo){
        return iRepositoryReclamo.findById(numero);
    }
    public List<Reclamo> getByEdificio(int codigo, IRepositoryReclamo iRepositoryReclamo){
        return iRepositoryReclamo.findByEdificio(codigo);
    }
    public List<Reclamo> getByUnidad(int identificador, IRepositoryReclamo iRepositoryReclamo){
        return iRepositoryReclamo.findByUnidad(identificador);
    }

    public void save(Reclamo reclamo, IRepositoryReclamo iRepositoryReclamo){
        iRepositoryReclamo.save(reclamo);
    }

    public void delete(int numero, IRepositoryReclamo iRepositoryReclamo){
        iRepositoryReclamo.deleteById(numero);
    }
    
    public void update(Reclamo reclamo, IRepositoryReclamo iRepositoryReclamo){
        if (iRepositoryReclamo.existsById(reclamo.getNumero())) {
        	iRepositoryReclamo.save(reclamo);
        }
    }
    
    


}
