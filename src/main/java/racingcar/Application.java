package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        new GameManager().startRace(scanner);
    }
}
