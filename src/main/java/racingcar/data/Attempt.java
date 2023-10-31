package racingcar.data;

public class Attempt {
    private final InputNumber inputNumber;

    public Attempt() {
        this.inputNumber = new InputNumber();
    }

    public void initInputNumber() {
        inputNumber.initRandomNumber();
    }
}
