package org.openapitools.modelDB;

import org.openapitools.interfaces.LikeInterface;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "likes")
@IdClass(LikeDBId.class) // Clase auxiliar para representar la clave compuesta
public class LikeDB implements Serializable, LikeInterface {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_usuario", nullable = false)
	private Integer idDeUsuario;

	@Id
	@Column(name = "id_contenido", nullable = false)
	private Integer idDeContenido;

	// Constructor vacío necesario para JPA
	public LikeDB() {
	}

	// Constructor que toma un Like para crear un LikeDB
	public LikeDB(Integer idDeUsuario, Integer idDeContenido) {
		this.idDeUsuario = idDeUsuario;
		this.idDeContenido = idDeContenido;
	}

	public void getLikeValues(LikeInterface likeInterface) {
		this.idDeContenido = likeInterface.getIdContenidoLike();
		this.idDeUsuario = likeInterface.getIdUsuarioLike();
	}

	@Override
	public Integer getIdContenidoLike() {
		return idDeContenido;
	}

	@Override
	public Integer getIdUsuarioLike() {
		return idDeUsuario;
	}

	// Getters y Setters
	public Integer getIdDeUsuario() {
		return idDeUsuario;
	}

	public void setIdDeUsuario(Integer idDeUsuario) {
		this.idDeUsuario = idDeUsuario;
	}

	public Integer getIdDeContenido() {
		return idDeContenido;
	}

	public void setIdDeContenido(Integer idDeContenido) {
		this.idDeContenido = idDeContenido;
	}

	// Equals y hashCode para la clave compuesta
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LikeDB likeDB = (LikeDB) o;

		if (!idDeUsuario.equals(likeDB.idDeUsuario)) return false;
		return idDeContenido.equals(likeDB.idDeContenido);
	}

	@Override
	public int hashCode() {
		int result = idDeUsuario.hashCode();
		result = 31 * result + idDeContenido.hashCode();
		return result;
	}
}
