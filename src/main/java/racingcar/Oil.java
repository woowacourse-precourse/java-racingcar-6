package racingcar;

public class Oil {

    private int size;

    public Oil(int size) {
        validateSizeCheck(size);
        this.size = size;
    }

    private void validateSizeCheck(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("1이상을 입력해주세요.");
        }
    }
}
