package racingcar.model;

public class Try {
    private int number;
    public Try(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("잘못된 횟수 입력");
        }
    }

    public int get() {
        return number;
    }

    public void decrease() {
        number--;
    }

    public boolean hasTry() {
        return (number > 0);
    }
}
