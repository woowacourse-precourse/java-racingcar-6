package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Car {
    String name;
    int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.count++;
        }
    }

    public void printCounts() {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }

    public void printMoves() {
        System.out.print(this.name + " : ");
        printCounts();
        System.out.print("\n");
    }
}

class Game {
    public static int MOVES;
    List<String> name;

    public void getCarNames() {
        String input = Console.readLine();
        name = Arrays.asList(input.split(","));
    }

    public void getNumberOfMoves() {
        MOVES = Integer.parseInt(Console.readLine());
    }
}