package org.example.controller;

import org.example.model.Writer;
import org.example.repository.WriterRepository;
import org.example.repository.gsonImpl.GsonWriterRepositoryImpl;

import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository = new GsonWriterRepositoryImpl();

    public Writer createWriter(String firstName, String lastName) {
        Writer writer = new Writer(0, firstName, lastName);
        return writerRepository.create(writer);
    }

    public Writer updateWriterById(Integer id, String firstName, String lastName) {
        Writer writer = new Writer(id, firstName, lastName);
        writer.setFirstName(firstName);
        writer.setLastName(lastName);
        return writerRepository.updateById(writer);
    }

    public Writer getWriterById(Integer id) {
        return writerRepository.getById(id);
    }

    public List<Writer> getAll() {
        return writerRepository.getAll();
    }

    public void deleteWriterById(Integer id) {
        writerRepository.getById(id);
    }

}
