package racingcar.model.randomnumber;

public class LowerNumber implements RandomNumber {

    private static final int NUMBER = 3;

    @Override
    public int pickNumber() {
        return NUMBER;
    }
}
