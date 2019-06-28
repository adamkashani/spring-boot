package core.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.bean.Person;
import core.logic.PersonService;

@RestController
@RequestMapping("/person")
public class PersonApi {

	private PersonService personService;

	@Autowired
	public PersonApi(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping
	@RequestMapping("/add")
	public long create(@RequestBody Person person) {
		return this.personService.create(person);
	}

	@PutMapping
	@RequestMapping("/update")
	public void update(@RequestBody Person person) {
		this.personService.update(person);
	}

	@GetMapping
	@RequestMapping("/get/{id}")
	public Person get(@PathVariable long id) {
		return this.personService.get(id);
	}
	
	@GetMapping
	@RequestMapping("getall")
	public List<Person> getAll(){
		return this.personService.getAll();
	}

	@DeleteMapping
	@RequestMapping(path = "/remove/{id}", produces = "text/plain")
	public String delete(@PathVariable long id) {
		return this.personService.delete(id);
	}

}
