package org.openapitools.modelDB;

import org.openapitools.interfaces.ContenidoInterface;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Contenido")
public class ContenidoDB implements ContenidoInterface{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String tipo;
	private String titulo;
	@Column(name = "production_year")
	private Integer productionYear;

	@Column(name = "clasificacion_edad")
	private String clasificacionEdad;

	private String descripcion;

	// Relación con la tabla Contenido
	@Column(name = "pertenece_a")
	private Integer perteneceA;

	@Column(name = "numero_elementos")
	private Integer numeroElementos;

	private Integer duracion;
	private String url;

	// Store the etiqueta IDs
	@ElementCollection
	@CollectionTable(name = "contenido_etiqueta", joinColumns = @JoinColumn(name = "contenido_id"))
	@Column(name = "etiqueta_id")
	private List<Integer> etiquetaIds;

	public ContenidoDB() {
		// Empty constructor
	}

	public ContenidoDB(String tipo, String titulo, Integer production_year, String clasificacionEdad, String descripcion, int perteneceA, Integer numeroElementos, Integer duracion, String url, List<Integer> etiquetaIds) {
		this.tipo = tipo;
		this.titulo = titulo;
		this.productionYear = production_year;
		this.clasificacionEdad = clasificacionEdad;
		this.descripcion = descripcion;
		this.perteneceA = perteneceA;
		this.numeroElementos = numeroElementos;
		this.duracion = duracion;
		this.url = url;
		this.etiquetaIds = etiquetaIds;
	}

	public List<Integer> getEtiquetaIds() {
		return etiquetaIds;
	}

	public void setEtiquetaIds(List<Integer> etiquetaIds) {
		this.etiquetaIds = etiquetaIds;
	}

	@Override
	public void getContenidoValues(ContenidoInterface contenidoInterface) {
		this.tipo = contenidoInterface.getTipoContenido();
		this.titulo = contenidoInterface.getTitulo();
		this.productionYear = contenidoInterface.getProductionYear();
		this.clasificacionEdad = contenidoInterface.getClasificacionEdad();
		this.descripcion = contenidoInterface.getDescripcion();
		this.numeroElementos = contenidoInterface.getNumeroElementos();
		this.duracion = contenidoInterface.getDuracion();
		this.url = contenidoInterface.getUrl();
		this.perteneceA = contenidoInterface.getPerteneceA();
		this.etiquetaIds = contenidoInterface.getEtiquetaIds();
	}

	@Override
	public Integer getIdContenido() {
		return id;
	}

	@Override
	public String getTipoContenido() {
		return tipo;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Integer production_year) {
		this.productionYear = production_year;
	}

	public String getClasificacionEdad() {
		return clasificacionEdad;
	}

	public void setClasificacionEdad(String clasificacionEdad) {
		this.clasificacionEdad = clasificacionEdad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPerteneceA() {
		return perteneceA;
	}

	public void setPerteneceA(Integer perteneceA) {
		this.perteneceA = perteneceA;
	}

	public Integer getNumeroElementos() {
		return numeroElementos;
	}

	public void setNumeroElementos(Integer numeroElementos) {
		this.numeroElementos = numeroElementos;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ContenidoDB{" + "id=" + id + ", tipo='" + tipo + '\'' + ", titulo='" + titulo + '\'' + ", production_year=" + productionYear + ", clasificacionEdad='" + clasificacionEdad + '\'' + ", descripcion='" + descripcion + '\'' + ", perteneceA=" + perteneceA + ", numeroElementos=" + numeroElementos + ", duracion=" + duracion + ", url='" + url + '\'' + '}';
	}
}
