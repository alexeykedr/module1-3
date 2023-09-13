package org.example.view.menu;

import java.util.Scanner;

public class MainMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    LabelMenu labelMenu = new LabelMenu();
    WriterMenu writerMenu = new WriterMenu();
    PostMenu postMenu = new PostMenu();

    @Override
    public void menu() {
        String choice;
        do {
            System.out.println("Выберите, с чем хотите работать:\n" + "1. Заголовки\n" + "2. Авторы\n" + "3. Посты\n" + "4. exit this app\n");

            choice = scanner.next();
            switch (choice) {
                case "1":
                    labelMenu.menu();
                    break;
                case "2":
                    writerMenu.menu();
                    break;
                case "3":
                    postMenu.menu();
                    break;
                case "4":
                    System.out.println("Программа завершена!");
                    break;

                default:
                    System.out.println("нераспознанное значение: " + choice.toLowerCase());
            }

        } while (!choice.equals("6"));
    }
}

