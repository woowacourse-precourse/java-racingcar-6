package racingcar.model;

public class Attempts {
    private final int number;

    public Attempts(int number) {
        this.number = number;
    }

    public Attempts(String value) {
        this.number = Integer.valueOf(value);
    }

    public int getNumber() {
        return number;
    }
}
