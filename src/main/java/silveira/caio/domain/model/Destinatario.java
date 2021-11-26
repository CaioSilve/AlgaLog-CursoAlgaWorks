package silveira.caio.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Destinatario {

	@NotBlank
	@Column(name = "destinatario_nome")
	private String nome;
	@NotBlank
	@Column(name = "destinatario_logra")
	private String logradouro;
	@NotBlank
	@Column(name = "destinatario_nume")
	private String numero;
	@NotBlank
	@Column(name = "destinatario_comple")
	private String complemento;
	@NotBlank
	@Column(name = "destinatario_bairro")
	private String bairro;
}
