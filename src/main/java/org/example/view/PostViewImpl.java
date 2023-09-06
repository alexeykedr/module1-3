package org.example.view;

import org.example.controller.PostControllerImpl;

import java.util.Scanner;

public class PostViewImpl implements PostView {
    Scanner scanner = new Scanner(System.in);
    PostControllerImpl postControllerimpl = new PostControllerImpl();

    @Override
    public void userMenu() {
        String choice;
        do {
            System.out.println("Выберите, что хотите сделать с постом:\n" +
                    "1. создать новый пост\n" +
                    "2. прочитать пост по id\n" +
                    "3. обновить пост по id\n" +
                    "4. удалить пост по id\n" +
                    "5. exit this menu\n");

            choice = scanner.next();
            switch (choice) {
                case "1":
                    System.out.println("Введите текст нового поста: \n");
                    scanner.nextLine(); // read line's empty end
                    String textNewPost = scanner.nextLine();
                    postControllerimpl.createPostUser(textNewPost);
                    System.out.println("Пост создан!");
                    break;

                case "2":
                    System.out.println("Введите id поста, который хотите прочитать: \n");
                    int postIdread = scanner.nextInt();
                    System.out.println(postControllerimpl.getPost(postIdread));
                    break;

                case "3":
                    System.out.println("Введите id поста, который хотите обновить: \n");
                    int postIdupdate = scanner.nextInt();
                    System.out.println("Введите новый текст поста для обновления: \n");
                    scanner.nextLine(); // read line's empty end
                    String textUpdatePost = scanner.nextLine();
                    postControllerimpl.updatePost(postIdupdate, textUpdatePost);
                    System.out.println("Пост обновлен!");
                    break;

                case "4":
                    System.out.println("Введите id поста, который хотите удалить: \n");
                    int postIddelete = scanner.nextInt();
                    postControllerimpl.deletePost(postIddelete);
                    System.out.println("Пост удален!");
                    break;

                case "5":
                    System.out.println("Программа завершена!");
                    break;

                default:
                    System.out.println("нераспознанное значение: " + choice.toLowerCase());
            }

        } while (!choice.equals("5"));

    }
}
