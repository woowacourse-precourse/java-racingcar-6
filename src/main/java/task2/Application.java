package task2;

import task2.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        GameController gameController = new GameController();
        try {
            gameController.run(scanner);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}