package org.openapitools.interfaces;

import java.util.List;

public interface ContenidoInterface {
	public void getContenidoValues(ContenidoInterface contenidoInterface);
	public Integer getIdContenido();
	public String getTipoContenido();
	public String getTitulo();
	public Integer getProductionYear();
	public String getClasificacionEdad();
	public String getDescripcion();
	public Integer getPerteneceA();
	public Integer getNumeroElementos();
	public Integer getDuracion();
	public String getUrl();
	public List<Integer> getEtiquetaIds();
}
