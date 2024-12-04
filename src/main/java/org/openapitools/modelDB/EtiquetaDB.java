package org.openapitools.modelDB;

import org.openapitools.interfaces.EtiquetaInterface;
import org.openapitools.model.Etiqueta;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Etiquetas")
public class EtiquetaDB implements EtiquetaInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    public EtiquetaDB() {
        // Empty constructor
    }

    public EtiquetaDB(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public void getEtiquetaValues(EtiquetaInterface etiquetaInterface) {
        this.nombre = etiquetaInterface.getNombre();
        this.id = etiquetaInterface.getIdEtiqueta();
    }

    public Integer getIdEtiqueta() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtiquetaDB that = (EtiquetaDB) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "EtiquetaDB{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
