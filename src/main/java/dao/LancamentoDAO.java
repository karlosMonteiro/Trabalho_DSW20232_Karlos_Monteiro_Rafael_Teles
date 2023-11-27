package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import models.entities.Lancamento;
import utils.JPAUtil;

public class LancamentoDAO {
	public static void salvar(Lancamento l) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(Lancamento l) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		l = em.find(Lancamento.class, l.getId());
		em.remove(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Lancamento acharPorId(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Lancamento l = em.find(Lancamento.class, id);
		em.close();
		return l;
	}
	
	public static List<Lancamento> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select l from Lancamento l");
		List<Lancamento> lista = q.getResultList();
		em.close();
		return lista;
	}
}
