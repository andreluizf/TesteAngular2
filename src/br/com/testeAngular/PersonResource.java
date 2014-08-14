package br.com.testeAngular;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sistema.web.repository.UsuarioRepository;
import br.com.testeAngular.model.Usuario;

//@ApplicationPath("/resources")
//@Stateless
@Path("persons")
public class PersonResource {

	@EJB(beanName = "UsuarioRepository")
	UsuarioRepository repo;

	static List<Person> lists;

	public PersonResource() {
		if (lists == null) {
			lists = new ArrayList<Person>();
			lists.add(new Person(1, "Andre", "33"));
			lists.add(new Person(2, "Renata", "30"));
			lists.add(new Person(3, "Vanilda", "55"));
			lists.add(new Person(4, "Mario", "50"));
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(Usuario user) {

		try {
			repo.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@POST
	@Path("alter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void alter(Usuario user) {
		repo.update(user);

	}

	@POST
	@Path("del")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void del(Usuario user) {
		repo.del(user);

	}

	@GET
	// @Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listPersons() {
		System.out.println(":::::::::::::lista");

		return repo.lists();
	}

}