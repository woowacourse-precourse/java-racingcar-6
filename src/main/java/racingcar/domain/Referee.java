package racingcar.domain;

public class Referee {
    public static boolean checkMoveForward() {
        NumberGenerator generator = new NumberGenerator();
        int number = generator.createRandomNumber();

        return number >= 4;
    }
}
