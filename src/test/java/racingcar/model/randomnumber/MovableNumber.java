package racingcar.model.randomnumber;

public class MovableNumber implements RandomNumber {

    private static final int NUMBER = 5;

    @Override
    public int pickNumber() {
        return NUMBER;
    }
}
