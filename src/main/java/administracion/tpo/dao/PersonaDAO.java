package administracion.tpo.dao;

import administracion.tpo.modelo.Persona;
import administracion.tpo.repository.IRepositoryPersona;

import java.util.List;
import java.util.Optional;

public class PersonaDAO {
    private static PersonaDAO instance;



    private PersonaDAO(){
    }

    public static PersonaDAO getInstance() {
        if(instance==null){
            instance = new PersonaDAO();
        }
        return instance;
    }

    public List<Persona> getAll(IRepositoryPersona iRepositoryPersona){
        return iRepositoryPersona.findAll();
    }
    public Optional<Persona> getById(String documento, IRepositoryPersona iRepositoryPersona){
        return iRepositoryPersona.findById(documento);
    }

    public void save(Persona persona, IRepositoryPersona iRepositoryPersona){
    iRepositoryPersona.save(persona);
    }

    public void delete(String documento, IRepositoryPersona iRepositoryPersona){
        iRepositoryPersona.deleteById(documento);
    }
    
    public void update(Persona p, IRepositoryPersona iRepositoryPersona){
        if (iRepositoryPersona.existsById(p.getDocumento())) {
        	iRepositoryPersona.save(p);
        }
    }
    public Optional<Persona> getByNombre (String nombre, IRepositoryPersona iRepositoryPersona){
        return iRepositoryPersona.findByNombre(nombre);
    }


}
