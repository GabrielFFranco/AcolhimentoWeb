package br.com.acolhimento.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.acolhimento.util.HibernateUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	// Método Salvar
	public void salvar(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		// Objeto que garante que uma operação seja executada de ponta a ponta.
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.save(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();
			}
			throw erro;

		} finally {

			sessao.close();
		}
	}

	// Método Listar
	public List<Entidade> listar() {

		// Pega e abre a sessão
		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		try {

			// Realiza a busca
			Criteria consulta = sessao.createCriteria(classe);

			@SuppressWarnings("unchecked")
			List<Entidade> resultado = consulta.list();

			return resultado;

		} catch (RuntimeException e) {

			System.out.println("Erro!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();

		} finally {

			sessao.close();

		}
		return null;
	}

	// Método para buscar
	@SuppressWarnings("unchecked")
	public Entidade buscar(Object codigo) {

		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		Entidade resultado = null;
		
		try {
					
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));

			resultado = (Entidade) consulta.uniqueResult();

		} catch (RuntimeException e) {
			System.out.println("Erro!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		return resultado;
	}

	// Método para excluir
	public void excluir(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		// Objeto que garante que uma operação seja executada de ponta a ponta.
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.delete(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();
			}

			throw erro;

		} finally {
			sessao.close();
		}
	}

	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		// Objeto que garante que uma operação seja executada de ponta a ponta.
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.update(entidade);

			transacao.commit();
			
		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();
			}

			throw erro;

		} finally {
			sessao.close();
		}

	}
}
