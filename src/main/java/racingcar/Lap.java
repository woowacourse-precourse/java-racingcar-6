package racingcar;

public class Lap {

    private int size;

    public Lap(String size) {
        validateFormatCheck(size);
        this.size = Integer.parseInt(size);
    }

    public Lap(int size) {
        validateSizeCheck(size);
        this.size = size;
    }

    private void validateFormatCheck(String size) {
        if (!size.matches("[1-9]+")) {
            throw new IllegalArgumentException("숫자를 입력 해 주세요.");
        }
    }

    private void validateSizeCheck(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("1이상을 입력 해 주세요.");
        }
    }

    public boolean isFinish(Lap lap) {
        return this.size < lap.size;
    }

}
