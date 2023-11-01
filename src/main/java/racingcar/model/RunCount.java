package racingcar.model;

public class RunCount {
    private int count;

    public RunCount(String inputRunCount) {
        this.count = convertStrToInt(inputRunCount);
        validatePositiveNumber(count);
    }

    private int convertStrToInt(String inputRunCount) {
        try {
            return Integer.parseInt(inputRunCount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }

    private void validatePositiveNumber(int countNum) {
        if (countNum <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return this.count;
    }
}
