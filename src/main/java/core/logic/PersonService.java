package core.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.bean.Person;
import core.dao.IPersonDao;

@Service
public class PersonService {

	private IPersonDao personDao;

	@Autowired
	public PersonService(IPersonDao personDao) {
		super();
		this.personDao = personDao;
	}

	public long create(Person person) {
		validate(person);
		person.setId(0);
		this.personDao.saveAndFlush(person);
		return person.getId();
	}

	public void update(Person person) {
		validate(person);
		Person personUpdate = this.get(person.getId());
		if (personUpdate != null) {
			personUpdate.setAge(person.getAge());
			personUpdate.setName(person.getName());
			personDao.saveAndFlush(personUpdate);
		} else {
			System.out.println("the person id not exists");
		}

	}

	public Person get(long id) {
		Person person =null;
		if(personDao.existsById(id)) {
			person = personDao.getOne(id);
		}
		return person;
	}

	public String delete(long id) { 
		// Check if the client cen delete this person

		// Check if the person id exists in db
		if (this.personDao.existsById(id)) {
			this.personDao.deleteById(id);
			return "remove person with id : " + id;
		} else {
			return "the id not exists in the db";
		}
	}

	private void validate(Person person) {
		// TODO Auto-generated method stub

	}

	public List<Person> getAll() {
		return this.personDao.findAll();
	}

}
