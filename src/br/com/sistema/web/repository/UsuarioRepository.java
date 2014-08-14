package br.com.sistema.web.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import br.com.testeAngular.model.Usuario;

@Stateless(name = "UsuarioRepository", mappedName = "ejb/UsuarioRepository")
@LocalBean
public class UsuarioRepository implements Repository<Usuario> {
	@PersistenceContext(unitName = "sistema")
	EntityManager em;

	@Override
	public List<Usuario> lists() {
		return em.createQuery("Select c from Usuario c", Usuario.class)
				.getResultList();
	}

	@Override
	public void save(Usuario classe) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(classe);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();

		}

	}

	@Override
	public void update(Usuario classe) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(classe);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();

		}

	}

	@Override
	public void del(Usuario classe) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.getReference(Usuario.class, classe.getId()));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();

		}

	}

}
