package br.com.acolhimento.domain;
// Generated 30/10/2018 15:29:30 by Hibernate Tools 5.2.11.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Funcionario generated by hbm2java
 */
@Entity
@Table(name = "funcionario", catalog = "acolhimento")
public class Funcionario implements java.io.Serializable {

	private String cpfFunc;
	private Endereco endereco;
	private String nomeFunc;
	private String rgFunc;
	private Date dataNascFunc;
	private String telefoneFunc;
	private String emailFunc;
	private String tipoFunc;
	private String statusFunc;
	private Set<Log> logs = new HashSet<Log>(0);
	private Set<Usuario> usuariosForAtendidoPeloFunc = new HashSet<Usuario>(0);
	private Set<Encaminhamento> encaminhamentos = new HashSet<Encaminhamento>(0);
	private Set<Usuario> usuariosForCpfFunc = new HashSet<Usuario>(0);

	public Funcionario() {
	}

	public Funcionario(String cpfFunc, String nomeFunc, String rgFunc, Date dataNascFunc, String telefoneFunc,
			String tipoFunc, String statusFunc) {
		this.cpfFunc = cpfFunc;
		this.nomeFunc = nomeFunc;
		this.rgFunc = rgFunc;
		this.dataNascFunc = dataNascFunc;
		this.telefoneFunc = telefoneFunc;
		this.tipoFunc = tipoFunc;
		this.statusFunc = statusFunc;
	}

	public Funcionario(String cpfFunc, Endereco endereco, String nomeFunc, String rgFunc, Date dataNascFunc,
			String telefoneFunc, String emailFunc, String tipoFunc, String statusFunc, Set<Log> logs,
			Set<Usuario> usuariosForAtendidoPeloFunc, Set<Encaminhamento> encaminhamentos,
			Set<Usuario> usuariosForCpfFunc) {
		this.cpfFunc = cpfFunc;
		this.endereco = endereco;
		this.nomeFunc = nomeFunc;
		this.rgFunc = rgFunc;
		this.dataNascFunc = dataNascFunc;
		this.telefoneFunc = telefoneFunc;
		this.emailFunc = emailFunc;
		this.tipoFunc = tipoFunc;
		this.statusFunc = statusFunc;
		this.logs = logs;
		this.usuariosForAtendidoPeloFunc = usuariosForAtendidoPeloFunc;
		this.encaminhamentos = encaminhamentos;
		this.usuariosForCpfFunc = usuariosForCpfFunc;
	}

	@Id

	@Column(name = "cpfFunc", unique = true, nullable = false, length = 20)
	public String getCpfFunc() {
		return this.cpfFunc;
	}

	public void setCpfFunc(String cpfFunc) {
		this.cpfFunc = cpfFunc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEndereco")
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Column(name = "nomeFunc", nullable = false, length = 30)
	public String getNomeFunc() {
		return this.nomeFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}

	@Column(name = "rgFunc", nullable = false, length = 15)
	public String getRgFunc() {
		return this.rgFunc;
	}

	public void setRgFunc(String rgFunc) {
		this.rgFunc = rgFunc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataNascFunc", nullable = false, length = 10)
	public Date getDataNascFunc() {
		return this.dataNascFunc;
	}

	public void setDataNascFunc(Date dataNascFunc) {
		this.dataNascFunc = dataNascFunc;
	}

	@Column(name = "telefoneFunc", nullable = false, length = 20)
	public String getTelefoneFunc() {
		return this.telefoneFunc;
	}

	public void setTelefoneFunc(String telefoneFunc) {
		this.telefoneFunc = telefoneFunc;
	}

	@Column(name = "emailFunc", length = 40)
	public String getEmailFunc() {
		return this.emailFunc;
	}

	public void setEmailFunc(String emailFunc) {
		this.emailFunc = emailFunc;
	}

	@Column(name = "tipoFunc", nullable = false, length = 12)
	public String getTipoFunc() {
		return this.tipoFunc;
	}

	public void setTipoFunc(String tipoFunc) {
		this.tipoFunc = tipoFunc;
	}

	@Column(name = "statusFunc", nullable = false, length = 10)
	public String getStatusFunc() {
		return this.statusFunc;
	}

	public void setStatusFunc(String statusFunc) {
		this.statusFunc = statusFunc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario")
	public Set<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionarioByAtendidoPeloFunc")
	public Set<Usuario> getUsuariosForAtendidoPeloFunc() {
		return this.usuariosForAtendidoPeloFunc;
	}

	public void setUsuariosForAtendidoPeloFunc(Set<Usuario> usuariosForAtendidoPeloFunc) {
		this.usuariosForAtendidoPeloFunc = usuariosForAtendidoPeloFunc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario")
	public Set<Encaminhamento> getEncaminhamentos() {
		return this.encaminhamentos;
	}

	public void setEncaminhamentos(Set<Encaminhamento> encaminhamentos) {
		this.encaminhamentos = encaminhamentos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionarioByCpfFunc")
	public Set<Usuario> getUsuariosForCpfFunc() {
		return this.usuariosForCpfFunc;
	}

	public void setUsuariosForCpfFunc(Set<Usuario> usuariosForCpfFunc) {
		this.usuariosForCpfFunc = usuariosForCpfFunc;
	}

}
