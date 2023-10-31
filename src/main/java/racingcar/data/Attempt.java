package racingcar.data;

public class Attempt {
    private final RandomNumber inputNumber;

    public Attempt() {
        this.inputNumber = new RandomNumber();
    }

    public void initInputNumber() {
        inputNumber.initRandomNumber();
    }
}
