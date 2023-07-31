package ar.edu.unlam.pb2.eva02;

import java.util.ArrayList;
import java.util.List;

public class Combo {
	private Integer id;
	private TipoArticulo tipoDeCombo;
	private List<Articulo> articulosEnCombo;
	
	public Combo(Integer Id,TipoArticulo tipocombo) {
		this.id=id;
		this.articulosEnCombo=new ArrayList<>();
		this.tipoDeCombo=tipocombo;
	}
	
	public void ingresarArticuloAlCombo(Articulo nuevoArticulo) throws TipoArticuloInvalidoException {
		if((nuevoArticulo instanceof Antiguedad && !(nuevoArticulo.getTipo() == tipoDeCombo) )
				|| (nuevoArticulo instanceof DeLujo && !(nuevoArticulo.getTipo() == tipoDeCombo))
				|| (nuevoArticulo instanceof Invaluable && !(nuevoArticulo.getTipo() == tipoDeCombo))
				|| (nuevoArticulo instanceof Exotico && !(nuevoArticulo.getTipo() == tipoDeCombo))) {
			throw new TipoArticuloInvalidoException();
		}
		articulosEnCombo.add(nuevoArticulo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoArticulo getTipoDeCombo() {
		return tipoDeCombo;
	}

	public void setTipoDeCombo(TipoArticulo tipoDeCombo) {
		this.tipoDeCombo = tipoDeCombo;
	}

	public List<Articulo> getArticulosEnCombo() {
		return articulosEnCombo;
	}

	public void setArticulosEnCombo(List<Articulo> articulosEnCombo) {
		this.articulosEnCombo = articulosEnCombo;
	}

	public Integer obtenerCantidadDeArticulos() {
		// TODO Auto-generated method stub
		return this.articulosEnCombo.size();
	}
	

}
