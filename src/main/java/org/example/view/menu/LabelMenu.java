package org.example.view.menu;

import org.example.view.LabelView;
import org.example.view.PostView;
import org.example.view.WriterView;

import java.util.Scanner;

public class LabelMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    LabelView labelView = new LabelView();

    @Override
    public void menu() {
         String choice;
        do {
            System.out.println("Выберите, что хотите сделать с заголовком (Label):\n" +
                    "1. создать новый заголовок\n" +
                    "2. прочитать заголовок по id\n" +
                    "3. прочитать все заголовоки\n" +
                    "4. обновить заголовок по id\n" +
                    "5. удалить заголовок по id\n" +
                    "6. exit menu Label\n");

             choice = scanner.next();
            switch (choice) {
                case "1":
                    labelView.createLabel();
                    break;
                case "2":
                    labelView.getLabelById();
                    break;
                case "3":
                    labelView.getAllLabels();
                    break;
                case "4":
                    labelView.updateLabelById();
                    break;
                case "5":
                    labelView.deleteLabelById();
                    break;
                case "6":
                    System.out.println("exit menu Label");
                    break;
                default:
                    System.out.println("нераспознанное значение: " + choice.toLowerCase());
            }
        } while (!choice.equals("6"));
    }
}
