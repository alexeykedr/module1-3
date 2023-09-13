package org.example.view;

import org.example.controller.LabelController;
import org.example.model.Label;

import java.util.List;
import java.util.Scanner;

public class LabelView {
    private final LabelController labelController = new LabelController();
    private final Scanner scanner = new Scanner(System.in);


    public void createLabel() {
        System.out.println("Enter name");

        String name = scanner.nextLine();
        Label createLabel = labelController.createLabel(name);
        System.out.println(createLabel);
        System.out.println("Label " + createLabel + " created!");

    }

    public void updateLabelById()  {
        System.out.println("Enter id");
        Integer id = scanner.nextInt();
        System.out.println("Enter name");
        String name = scanner.nextLine();


        Label updateLabel = labelController.updateLabelById(id, name);
        System.out.println("Label " + updateLabel + " updated");
    }

    public void getLabelById() {
        System.out.println("Enter id:");

        Integer id = scanner.nextInt();
        Label label = labelController.getLabelById(id);
        System.out.println("Label " + label);
    }

    public List<Label> getAllLabels() {
      List<Label> labels = labelController.getAll();
        System.out.println(labels);
        return labels;
    }

    public void deleteLabelById() {
        System.out.println("Enter id:");

        Integer id = scanner.nextInt();
        labelController.deleteLabelById(id);
        System.out.println("Label deleted!");
    }
}
