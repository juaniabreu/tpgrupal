package administracion.tpo.modelo;

import administracion.tpo.views.ImagenView;
import jakarta.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagen {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numero;
	@Column(name = "path")
	private String direccion;
	@Column(name = "tipo")
	private String tipo;


	public Imagen(){}
	public Imagen(String direccion, String tipo) {
		this.direccion = direccion;
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void save(int numeroReclamo) {
		
	}
	public ImagenView toView() {
		return new ImagenView(numero, direccion, tipo);
	}

	@Override
	public String toString() {
		return "Imagen{" +
				"numero=" + numero +
				", direccion='" + direccion + '\'' +
				", tipo='" + tipo + '\'' +
				'}';
	}
}
