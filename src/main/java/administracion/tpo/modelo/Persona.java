package administracion.tpo.modelo;

import administracion.tpo.views.PersonaView;
import jakarta.persistence.*;

@Entity
@Table(name="personas")
public class Persona {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String documento;
	@Column(name = "nombre")
	private String nombre;
	

	public Persona(){

	}
	public Persona(String documento, String nombre) {
		this.documento = documento;
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public PersonaView toView() {
		return new PersonaView(documento, nombre);
	}

	public void save() {

	}

	public void delete() {

	}

	@Override
	public String toString() {
		return "Persona{" +
				"documento='" + documento + '\'' +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
