package silveira.caio.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;
import silveira.caio.domain.model.StatusEntrega;

@Getter
@Setter
public class EntregaResponse {

	
	private Long id;
	private ClienteResumoResponse cliente;
	private DestinatarioResponse destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
	
}
