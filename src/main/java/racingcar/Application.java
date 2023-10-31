package racingcar;

import racingcar.domain.Checker;

public class Application {
    public static void main(String[] args) {
//        Input input = new Input();
//        System.out.println(input.carsName());
//        System.out.println(input.numberOfAttempts());
        Checker checker = new Checker();
        System.out.println(checker.advance());
    }
}
