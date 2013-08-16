package es.luceit.mylifeinshort.main;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

@Named
@RequestScoped
public class ExampleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public void buscar() {
		Session session = (Session) em.getDelegate();
		List<Object[]> resultados = session
				.createSQLQuery("SELECT * FROM TEST").list();
		for (Object[] objeto : resultados) {
			System.out.println("Objeto: " + objeto[0] + " " + objeto[1]);
		}
	}
}
