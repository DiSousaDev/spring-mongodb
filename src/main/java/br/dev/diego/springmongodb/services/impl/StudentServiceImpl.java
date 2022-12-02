package br.dev.diego.springmongodb.services.impl;

import br.dev.diego.springmongodb.entities.Student;
import br.dev.diego.springmongodb.repositories.StudentRepository;
import br.dev.diego.springmongodb.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public Collection<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student insert(Student request) {
        return repository.insert(request);
    }

}
