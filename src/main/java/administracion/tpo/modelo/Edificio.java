package administracion.tpo.modelo;

import administracion.tpo.views.EdificioView;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;


@Entity
@Table(name = "edificios")
public class Edificio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	private String nombre;
	
	private String direccion;
	
	//@Column(name = "unidades")
	/*
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "codigoedificio" ) //mappedBy = "edificio"
	@JoinColumn(name = "identificador")
	private List<Unidad> unidades=new ArrayList<Unidad>();
	*/
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Unidad> unidades=new ArrayList<Unidad>();

	public Edificio(){

	}
	public Edificio( String nombre, String direccion) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		unidades = new ArrayList<Unidad>();
	}
	
	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}
	
	public Set<Persona> habilitados(){
		Set<Persona> habilitados = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			List<Persona> duenios = unidad.getDuenios();
			for(Persona p : duenios)
				habilitados.add(p);
			List<Persona> inquilinos = unidad.getInquilinos();
			for(Persona p : inquilinos)
				habilitados.add(p);
		}
		return habilitados;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public Set<Persona> duenios() {
		Set<Persona> resultado = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			List<Persona> duenios = unidad.getDuenios();
			for(Persona p : duenios)
				duenios.add(p);
		}
		return resultado;
	}

	public Set<Persona> habitantes() {
		Set<Persona> resultado = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			if(unidad.estaHabitado()) {
				List<Persona> inquilinos = unidad.getInquilinos();
				if(inquilinos.size() > 0) 
					for(Persona p : inquilinos)
						resultado.add(p);
				else {
					List<Persona> duenios = unidad.getDuenios();
					for(Persona p : duenios)
						resultado.add(p);
				}
			}
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Edificio{" +
				"codigo=" + codigo +
				", nombre='" + nombre + '\'' +
				", direccion='" + direccion + '\'' +
				'}';
	}

	public EdificioView toView() {
		return new EdificioView(codigo, nombre, direccion);
	}
}
