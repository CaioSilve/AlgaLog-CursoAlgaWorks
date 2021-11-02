package silveira.caio.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


//CAMPOS NULOS NÃO APARECEM
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ExceptionComum {

	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	
	@Getter
	@AllArgsConstructor
	public static class Campo {
		private String nome;
		private String msg;
	}
	
}
