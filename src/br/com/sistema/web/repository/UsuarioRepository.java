package br.com.sistema.web.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.testeAngular.model.Usuario;

@Stateless(name = "UsuarioRepository")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioRepository {
    @PersistenceContext(unitName = "sistema")
    EntityManager em;
    
    public List<Usuario> listCliente(){
    	System.out.println("aki");
    	return em.createQuery("Select c from Usuario c",Usuario.class).getResultList();
    	
    }

}
