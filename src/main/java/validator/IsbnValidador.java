package validator;

import java.io.Serializable;

import javax.faces.validator.FacesValidator;

import org.apache.commons.validator.routines.ISBNValidator;


@FacesValidator("isbnValidator")
public class IsbnValidador extends ISBNValidator implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IsbnValidador() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String validate(String code) {
		// TODO Auto-generated method stub
		return super.validate(code);
	}
	
}



	