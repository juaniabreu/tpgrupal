package administracion.tpo;

import administracion.tpo.dao.*;
import administracion.tpo.modelo.*;
import administracion.tpo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class TpoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TpoApplication.class, args);
	}

	@Autowired
	 IRepositoryPersona repositoryPersona;
	@Autowired
	 IRepositoryEdificio repositoryEdificio;
	@Autowired
	 IRepositoryUnidad repositoryUnidad;
	@Autowired
	 IRepositoryImagen repositoryImagen;
	@Autowired
	 IRepositoryReclamo repositoryReclamo;
	
	

	@Override
	public void run(String... args) throws Exception {
		/*
		List<Persona> list = PersonaDAO.getInstance().getAll(repositoryPersona);
		for(Persona p : list) {
			System.out.println(p.toString());
		}
		*/

		/*
		Edificio ed = new Edificio("edificio1", "direccion1");
		EdificioDAO.getInstance().save(ed, repositoryEdificio);
		*/
		
		
		/*
		List<Edificio> listEdificio = EdificioDAO.getInstance().getAll(repositoryEdificio);
		for(Edificio e : listEdificio) {
			System.out.println(e.toString());
		}
		*/
		
		/*
		List<Unidad>uni=UnidadDAO.getInstance().getAll(repositoryUnidad);
		Unidad un=uni.get(10);
		for(Persona u: un.getInquilinos()) {
			System.out.println(u.toString());
		}
		*/
		
		Optional<Edificio> e =EdificioDAO.getInstance().getById(1, repositoryEdificio);
		if(e.isPresent()) {
			Edificio ed=e.get();
			
			System.out.println(ed.toString());
		}else {
			System.out.println("no existe ese edificio");
		}
		
		/*
		Optional<Unidad>un=UnidadDAO.getInstance().getById(2, repositoryUnidad);
		Unidad unidad=un.get();
		
		System.out.println(unidad.toString());
		
		Imagen i=new Imagen(ed.getDireccion(),"PNG");
		System.out.println(i.toString());
		
		Optional<Persona>p=PersonaDAO.getInstance().getById("CI 13230978", repositoryPersona);
		Persona pe=p.get();
		
		System.out.println(pe.toString());
		
		Reclamo r=new Reclamo(pe,ed,ed.getDireccion(),"Gotera",unidad,1);
		ReclamoDAO.getInstance().save(r, repositoryReclamo);
		
			*/
		
		
		/*
		Edificio ed = new Edificio("edificio1", "direccion1");
		EdificioDAO.getInstance().save(ed, repositoryEdificio);
		
		Unidad un = new Unidad("3","4", ed);
		UnidadDAO.getInstance().save(un, repositoryUnidad);
		 */
		
		
		/*
		Optional<Edificio> ed=EdificioDAO.getInstance().getById(1, repositoryEdificio);
		Edificio ed2=ed.get();
		Unidad un = new Unidad("3","4", ed2);
		UnidadDAO.getInstance().save(un, repositoryUnidad);

		List<Unidad>listauni=UnidadDAO.getInstance().getAll(repositoryUnidad);
		System.out.println(listauni.get(2).estaHabitado());
		
		for(Unidad u: listauni) {
			System.out.println(u.toString());
		}*/
		
		/*
		List<Persona>listaUnidad = PersonaDAO.getInstance().getAll(repositoryPersona);
		for(Persona p: listaUnidad) {
			System.out.println(p.toString());
		}
		*/
		
		
		/*
		Optional<Unidad>u=UnidadDAO.getInstance().getById(1, repositoryUnidad);
		Unidad un=u.get();
		
		for(Persona p: un.getDuenios()) {
			System.out.println(p.toString());
		}
		*/
		
		/*
		List<Reclamo>reclamos=ReclamoDAO.getInstance().getAll(repositoryReclamo);
		for(Reclamo r: reclamos) {
			System.out.println(r.toString());
		}
		*/

		}
	

	
	

}
