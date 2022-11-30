package br.dev.diego.springmongodb;

import br.dev.diego.springmongodb.entities.Address;
import br.dev.diego.springmongodb.entities.Gender;
import br.dev.diego.springmongodb.entities.Student;
import br.dev.diego.springmongodb.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
public class SpringMongodbApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Address address = Address.builder()
                .city("Rio de Janeiro")
                .country("Brasil")
                .postCode("01234000")
                .build();

        Student student = Student.builder()
                .firstName("Bob")
                .lastName("Brown")
                .email("bob@gmail.com")
                .gender(Gender.MALE)
                .address(address)
                .createdAt(Instant.now())
                .favouriteSubjects(Arrays.asList("Java", "HTML", "CSS"))
                .totalSpentInBooks(BigDecimal.TEN)
                .build();

//		repository.insert(student);

//		Query query = new Query();
//		query.addCriteria(Criteria.where("email").is("bob@gmail.com"));
//		List<Student> students = mongoTemplate.find(query, Student.class);
//		students.forEach(System.out::println
//		);

        repository.findStudentByEmail("bob@gmail.com")
                .ifPresentOrElse(s -> {
                    System.out.println(s + " already exists");
                }, () -> {
                    System.out.println("Inserting student");
                    repository.insert(student);
                });


    }
}
