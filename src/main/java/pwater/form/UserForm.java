package pwater.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data //support getter setter
public class UserForm {

	@NotNull(message = "Must email is not null!")
	@Size(min = 8, max = 35, message = "Please enter correctly required length of email!")
	private String email;

}