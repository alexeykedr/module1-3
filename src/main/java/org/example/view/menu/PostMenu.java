package org.example.view.menu;

import org.example.view.PostView;

import java.util.Scanner;

public class PostMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    PostView postView = new PostView();

    @Override
    public void menu() {
        String choice;
        do {
            System.out.println("Выберите, что хотите сделать с постом:\n" +
                    "1. создать новый пост\n" +
                    "2. прочитать пост по id\n" +
                    "3. прочитать все посты\n" +
                    "4. обновить пост по id\n" +
                    "5. удалить пост по id\n" +
                    "6. exit menu Post\n");

            choice = scanner.next();
            switch (choice) {
                case "1":
                    postView.createPost();
                    break;
                case "2":
                    postView.getPostById();
                    break;
                case "3":
                    postView.getAllPosts();
                    break;
                case "4":
                    postView.updatePostById();
                    break;
                case "5":
                    postView.deletePostById();
                    break;
                case "6":
                    System.out.println("exit menu Post");
                    break;

                default:
                    System.out.println("нераспознанное значение: " + choice.toLowerCase());
            }

        } while (!choice.equals("6"));
    }
}

