package br.com.acolhimento.teste.dao;

import java.util.List;

import org.junit.Test;

import br.com.acolhimento.dao.EmpresaDAO;
import br.com.acolhimento.dao.EnderecoDAO;
import br.com.acolhimento.domain.Empresa;
import br.com.acolhimento.domain.Endereco;

public class EmpresaDAOTest {

	// @Test
	public void salvarEmpresa() {

		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = new Endereco();

		endereco.setBairro("Centro");
		endereco.setCep("86480-000");
		endereco.setCidade("Conseairinck");
		endereco.setNumeroEnd(Short.parseShort("138"));
		endereco.setEndereco("Rua Guri");

		enderecoDAO.salvar(endereco);

		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = new Empresa();

		empresa.setCnpjEmp("14gggg4");
		empresa.setNomeEmp("Uns Ai");
		empresa.setNumeroVagasEmp(Short.parseShort("40"));
		empresa.setRazaoSocialEmp("A gente faz uns por ai.");
		empresa.setEndereco(enderecoDAO.ultimoEndereco());

		empresaDAO.salvar(empresa);

	}

	// @Test
	public void listarEmpresa() {

		EnderecoDAO enderecoDAO = new EnderecoDAO();

		EmpresaDAO empresaDAO = new EmpresaDAO();

		List<Endereco> lista = enderecoDAO.listar();
		List<Empresa> listaEmpresa = empresaDAO.listar();

		for (Empresa empresa : listaEmpresa) {
			System.out.println(empresa.getCnpjEmp());
			System.out.println(empresa.getNomeEmp());
			System.out.println(empresa.getRazaoSocialEmp());
			System.out.println(empresa.getEndereco().getIdEndereco());
			System.out.println(empresa.getNumeroVagasEmp());
		}
		for (Endereco endereco : lista) {
			System.out.println(endereco.getBairro());
			System.out.println(endereco.getCep());
			System.out.println(endereco.getCidade());
			System.out.println(endereco.getEndereco());
			System.out.println(endereco.getNumeroEnd());
		}

	}

	//@Test
	public void buscarEmpresa() {

		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = empresaDAO.buscar("124444");

		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscar(empresa.getEndereco().getIdEndereco());

		System.out.println(empresa.getCnpjEmp());
		System.out.println(empresa.getNomeEmp());
		System.out.println(empresa.getRazaoSocialEmp());
		System.out.println(empresa.getEndereco().getIdEndereco());
		System.out.println(empresa.getNumeroVagasEmp());

		System.out.println(endereco.getBairro());
		System.out.println(endereco.getCep());
		System.out.println(endereco.getCidade());
		System.out.println(endereco.getEndereco());
		System.out.println(endereco.getNumeroEnd());

	}
	
	//@Test
	public void editarEmpresa() {
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = empresaDAO.buscar("124444");

		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscar(empresa.getEndereco().getIdEndereco());
	
		endereco.setCep("434343434");
		enderecoDAO.editar(endereco);
		
		empresa.setNomeEmp("hahahahahahaha");
		empresaDAO.editar(empresa);
	}
	
	//@Test
	public void excluirEmpresa() {
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = empresaDAO.buscar("124444");

		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscar(empresa.getEndereco().getIdEndereco());
		
		enderecoDAO.excluir(endereco);
		empresaDAO.excluir(empresa);
		
	}

}
