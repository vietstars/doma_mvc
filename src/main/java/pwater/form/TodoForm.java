package pwater.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class TodoForm {

	@NotNull(message = "Must task is not null!")
	@Size(min = 3, max = 350, message = "Please enter correctly required length of task!")
	private String task;

}