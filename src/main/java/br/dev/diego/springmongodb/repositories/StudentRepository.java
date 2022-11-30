package br.dev.diego.springmongodb.repositories;

import br.dev.diego.springmongodb.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}
