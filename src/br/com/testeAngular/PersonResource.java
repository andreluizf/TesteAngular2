package br.com.testeAngular;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@ApplicationPath("/resources")
@Path("persons")
public class PersonResource {

	static List<Person> lists;

	public PersonResource() {
		if (lists==null) {
			lists= new ArrayList<Person>();
			lists.add(new Person(1,"Andre", "33"));
			lists.add(new Person(2,"Renata", "30"));
			lists.add(new Person(3,"Vanilda", "55"));
			lists.add(new Person(4,"Mario", "50"));
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(Person user) {
		System.out.println(":::::::::::::create" + user.toString());
		lists.add(new Person(lists.size()+1,user.getNome(), user.getIdade()));
		System.out.println(lists.size());
	}
	@POST
	@Path("alter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void alter(Person user) {
		System.out.println(":::::::::::::alter" + user.toString());
		
	}
	@POST
	@Path("del")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void del(Person user) {
		System.out.println(":::::::::::::del" + user.toString());
		
	}

	@GET
	// @Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> listPersons() {
		System.out.println(":::::::::::::lista");

		return lists;
	}

}