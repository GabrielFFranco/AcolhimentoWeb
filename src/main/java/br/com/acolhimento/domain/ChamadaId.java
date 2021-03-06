package br.com.acolhimento.domain;
// Generated 30/10/2018 15:29:30 by Hibernate Tools 5.2.11.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ChamadaId generated by hbm2java
 */
@Embeddable
public class ChamadaId implements java.io.Serializable {

	private Date idChamadaData;
	private int nprontuarioUsu;

	public ChamadaId() {
	}

	public ChamadaId(Date idChamadaData, int nprontuarioUsu) {
		this.idChamadaData = idChamadaData;
		this.nprontuarioUsu = nprontuarioUsu;
	}

	@Column(name = "idChamadaData", nullable = false, length = 10)
	public Date getIdChamadaData() {
		return this.idChamadaData;
	}

	public void setIdChamadaData(Date idChamadaData) {
		this.idChamadaData = idChamadaData;
	}

	@Column(name = "nProntuarioUsu", nullable = false)
	public int getNprontuarioUsu() {
		return this.nprontuarioUsu;
	}

	public void setNprontuarioUsu(int nprontuarioUsu) {
		this.nprontuarioUsu = nprontuarioUsu;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ChamadaId))
			return false;
		ChamadaId castOther = (ChamadaId) other;

		return ((this.getIdChamadaData() == castOther.getIdChamadaData())
				|| (this.getIdChamadaData() != null && castOther.getIdChamadaData() != null
						&& this.getIdChamadaData().equals(castOther.getIdChamadaData())))
				&& (this.getNprontuarioUsu() == castOther.getNprontuarioUsu());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdChamadaData() == null ? 0 : this.getIdChamadaData().hashCode());
		result = 37 * result + this.getNprontuarioUsu();
		return result;
	}

}
