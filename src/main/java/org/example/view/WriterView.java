package org.example.view;

import org.example.controller.WriterController;
import org.example.model.Writer;

import java.util.List;
import java.util.Scanner;

public class WriterView {
    private final WriterController writerController = new WriterController();
    private final Scanner scanner = new Scanner(System.in);

    public void createWriter() {
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();

        Writer createWriter = writerController.createWriter(firstName, lastName);
        System.out.println("Writer " + createWriter + " created!");

    }

    public void updateWriterById() {
        System.out.println("Enter id");
        Integer id = scanner.nextInt();
        System.out.println("Enter new first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter new last name");
        String lastName = scanner.nextLine();

        Writer updateWriter = writerController.updateWriterById(id, firstName, lastName);
        System.out.println("Writer " + updateWriter + " updated");
    }

    public void getWriterById() {
        System.out.println("Enter id:");

        Integer id = scanner.nextInt();
        Writer writer = writerController.getWriterById(id);
        System.out.println("Writer " + writer);
    }

    public List<Writer> getAllWriters() {
        List<Writer> writers = writerController.getAll();
        System.out.println(writers);
        return writers;
    }

    public void deleteWriterById() {
        System.out.println("Enter id:");

        Integer id = scanner.nextInt();
        writerController.deleteWriterById(id);
        System.out.println("Writer deleted!");
    }
}



