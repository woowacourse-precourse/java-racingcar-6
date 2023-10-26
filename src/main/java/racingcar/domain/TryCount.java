package racingcar.domain;

public class TryCount {

    private final int count;

    private TryCount(int count) {  // 생성자를 private로 변경
        this.count = count;
    }

    public static TryCount of(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
        return new TryCount(count);
    }
}
