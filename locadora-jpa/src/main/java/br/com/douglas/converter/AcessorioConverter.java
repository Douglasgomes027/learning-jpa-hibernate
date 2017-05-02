package br.com.douglas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.douglas.dao.AcessorioDAO;
import br.com.douglas.model.Acessorio;



@FacesConverter("acessorioConverter")
public class AcessorioConverter implements Converter {

	@Inject
	private AcessorioDAO acessorioDAO;
	
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Acessorio retorno = null;
		
		if (StringUtils.isNotBlank(value)) {
			retorno = this.acessorioDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Acessorio) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}