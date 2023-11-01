package racingcar;

import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
//        NumberGenerator generator = new NumberGenerator();
//        int number = generator.createRandomNumber();
//        System.out.println(number);

        boolean moving1 = Referee.checkMoveForward();
        boolean moving2 = Referee.checkMoveForward();
        System.out.println(moving1);
        System.out.println(moving2);

    }
}
