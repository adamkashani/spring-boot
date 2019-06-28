package core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import core.bean.Person;

@Repository
public interface IPersonDao extends JpaRepository<Person, Long> {

}
