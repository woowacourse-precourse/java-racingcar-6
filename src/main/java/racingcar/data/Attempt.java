package racingcar.data;

public class Attempt {
    private final RandomNumbers randomNumbers;

    public Attempt(int pickTotal) {
        this.randomNumbers = new RandomNumbers(pickTotal);
    }

    public void initRandomNumber() {
        randomNumbers.init();
    }
}
