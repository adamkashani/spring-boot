package core.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stam {

	@Id
	@GeneratedValue
	private long id ; 
	
	@Column
	private String name ; 
	
}
