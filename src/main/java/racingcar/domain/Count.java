package racingcar.domain;

public class Count {

    private final int count;

    public Count(String countInput) {
        this.count = convertToInt(countInput);
    }

    private int convertToInt(String countInput) {
        int count = 0;
        try {
            count = Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 횟수는 숫자여야 합니다.");
        }
        return count;
    }

    public int getCount() {
        return count;
    }
}
