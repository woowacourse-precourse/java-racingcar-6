package racingcar;

import racingcar.domain.Input;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        System.out.println(input.carsName());
        System.out.println(input.numberOfAttempts());
    }
}
