package org.example.view.menu;

import org.example.view.WriterView;

import java.util.Scanner;

public class WriterMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    WriterView writerView = new WriterView();

    @Override
    public void menu() {
        String choice;
        do {
            System.out.println("Выберите, что хотите сделать с автором\n" +
                    "1. создать нового автора\n" +
                    "2. получить автора по id\n" +
                    "3. прочитать всех авторов\n" +
                    "4. обновить автора по id\n" +
                    "5. удалить автора по id\n" +
                    "6. exit menu Writer\n");

            choice = scanner.next();
            switch (choice) {
                case "1":
                    writerView.createWriter();
                    break;
                case "2":
                    writerView.getWriterById();
                    break;
                case "3":
                    writerView.getAllWriters();
                    break;
                case "4":
                    writerView.updateWriterById();
                    break;
                case "5":
                    writerView.deleteWriterById();
                    break;
                case "6":
                    System.out.println("exit menu Writer");
                    break;
                default:
                    System.out.println("нераспознанное значение: " + choice.toLowerCase());
            }
        } while (!choice.equals("6"));
    }
}

