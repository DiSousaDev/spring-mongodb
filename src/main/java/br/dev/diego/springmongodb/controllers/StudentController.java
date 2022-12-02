package br.dev.diego.springmongodb.controllers;

import br.dev.diego.springmongodb.entities.Student;
import br.dev.diego.springmongodb.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public ResponseEntity<Collection<Student>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student request) {
        return ResponseEntity.ok(service.insert(request));
    }

}
