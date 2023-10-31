package racingcar.data;

public class Attempt {
    private final RandomNumber randomNumber;

    public Attempt() {
        this.randomNumber = new RandomNumber();
    }

    public void initRandomNumber() {
        randomNumber.init();
    }
}
