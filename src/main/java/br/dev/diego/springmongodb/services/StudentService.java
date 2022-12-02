package br.dev.diego.springmongodb.services;

import br.dev.diego.springmongodb.entities.Student;

import java.util.Collection;

public interface StudentService {

    Collection<Student> getAll();

    Student insert(Student request);

}
