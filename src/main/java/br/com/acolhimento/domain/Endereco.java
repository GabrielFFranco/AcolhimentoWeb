package br.com.acolhimento.domain;
// Generated 30/10/2018 15:29:30 by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Endereco generated by hbm2java
 */
@Entity
@Table(name = "endereco", catalog = "acolhimento")
public class Endereco implements java.io.Serializable {

	private Integer idEndereco;
	private String endereco;
	private Short numeroEnd;
	private String bairro;
	private String cidade;
	private String cep;
	private Set<Empresa> empresas = new HashSet<Empresa>(0);
	private Set<Funcionario> funcionarios = new HashSet<Funcionario>(0);
	private Set<Encaminhamento> encaminhamentos = new HashSet<Encaminhamento>(0);
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Endereco() {
	}

	public Endereco(String endereco, Short numeroEnd, String bairro, String cidade, String cep, Set<Empresa> empresas,
			Set<Funcionario> funcionarios, Set<Encaminhamento> encaminhamentos, Set<Usuario> usuarios) {
		this.endereco = endereco;
		this.numeroEnd = numeroEnd;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.empresas = empresas;
		this.funcionarios = funcionarios;
		this.encaminhamentos = encaminhamentos;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idEndereco", unique = true, nullable = false)
	public Integer getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	@Column(name = "endereco", length = 60)
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "numeroEnd")
	public Short getNumeroEnd() {
		return this.numeroEnd;
	}

	public void setNumeroEnd(Short numeroEnd) {
		this.numeroEnd = numeroEnd;
	}

	@Column(name = "bairro", length = 30)
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "cidade", length = 30)
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name = "cep", length = 15)
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	public Set<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	public Set<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	public Set<Encaminhamento> getEncaminhamentos() {
		return this.encaminhamentos;
	}

	public void setEncaminhamentos(Set<Encaminhamento> encaminhamentos) {
		this.encaminhamentos = encaminhamentos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
