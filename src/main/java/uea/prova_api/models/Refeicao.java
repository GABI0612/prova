package uea.prova_api.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uea.prova_api.models.enums.TipoRefeicao;

@Entity
public class Refeicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private LocalDateTime dataConsumo;
	private TipoRefeicao tipoRefeicao;

	@JsonIgnoreProperties(value = { "consumidores" })
	@ManyToOne
	@JoinColumn(name = "consumidores_id")
	private Consumidor consumidor;

	public Refeicao() {
		super();
	}

	public Refeicao(Long codigo, LocalDateTime dataConsumo, TipoRefeicao tipoRefeicao, Consumidor consumidor) {
		super();
		this.codigo = codigo;
		this.dataConsumo = dataConsumo;
		this.tipoRefeicao = tipoRefeicao;
		this.consumidor = consumidor;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataConsumo() {
		return dataConsumo;
	}

	public void setDataConsumo(LocalDateTime dataConsumo) {
		this.dataConsumo = dataConsumo;
	}

	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refeicao other = (Refeicao) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
