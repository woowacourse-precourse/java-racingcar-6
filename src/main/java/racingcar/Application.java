package racingcar;

import racingcar.domain.Input;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playRacingCar();
    }

    private static void playRacingCar() {

        Input input = new Input();

        List<String> names = input.createNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
        int moveCount = input.moveCount();
        System.out.println("moveCount = " + moveCount);
    }
}
