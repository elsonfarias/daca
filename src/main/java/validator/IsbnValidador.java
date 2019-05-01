package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.validator.routines.ISBNValidator;

@FacesValidator("isbnValidador")
public class IsbnValidador implements Validator<String> {
	
	ISBNValidator validador = new ISBNValidator();
	
	
	@Override
	public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
		String result = validador.validate(value);
		
		
		if (result == null || result.trim().length() < 10) {
			FacesMessage msg = new FacesMessage("Erro de validação do ISBN.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		
	}

		
}
