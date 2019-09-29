package org.edival.silva.cartoriosDocket.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.edival.silva.cartoriosDocket.model.Cartorio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartorioDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Cartorio cartorio) {
		manager.persist(cartorio);
	}
	
	public void editar(Cartorio cartorio, Long id) {
		manager.createQuery
			("update Cartorio c set c.nome = :novoNome where c.id = :idCartorio")
			.setParameter("novoNome", cartorio.getNome())
			.setParameter("idCartorio", id)
			.executeUpdate();
	}

	public List<Cartorio> listarTodos() {
		return manager.createQuery("select c from Cartorio c", Cartorio.class)
				.getResultList();
	}
	
	public Cartorio buscarPorId(Long id) {
		return manager.createQuery("select c from Cartorio c where c.id = :idCartorio", Cartorio.class)
				.setParameter("idCartorio", id)
				.getSingleResult();
	}
	
	public void inativar(Long id) {
		manager.createQuery("UPDATE Cartorio SET Ativo=0 WHERE id = :idCartorio")
		.setParameter("idCartorio", id)
		.executeUpdate();
	}
}
