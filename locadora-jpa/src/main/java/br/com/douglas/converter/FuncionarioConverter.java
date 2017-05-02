package br.com.douglas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.douglas.dao.FuncionarioDAO;
import br.com.douglas.model.Funcionario;



@FacesConverter(forClass=Funcionario.class)
public class FuncionarioConverter implements Converter {

	@Inject
	private FuncionarioDAO funcionarioDAO;
	
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Funcionario retorno = null;

		if (StringUtils.isNotBlank(value)) {
			retorno = this.funcionarioDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Funcionario) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}