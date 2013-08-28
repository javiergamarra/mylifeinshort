package es.luceit.mylifeinshort.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	private String description;
	
	@ManyToMany (mappedBy="technologies")
	private List<People> people = new ArrayList<People>();

	public final List<People> getPeople() {
		return people;
	}

	public final void setPeople(List<People> people) {
		this.people = people;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}
	
	public void addPeople(People people)
	{
	    this.people.add(people);
	    people.addTechnology(this);
	}

}
