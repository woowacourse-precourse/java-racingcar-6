package racingcar.dto;

public class TryCount {

    private final Integer count;

    private TryCount(Integer count) {
        validateNonNegativeCount(count);
        this.count = count;
    }

    public static TryCount fromInput(String input) {
        try {
            return new TryCount(Integer.valueOf(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getCount() {
        return count;
    }

    private void validateNonNegativeCount(Integer count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }
}
