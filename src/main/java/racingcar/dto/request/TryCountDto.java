package racingcar.dto.request;

public class TryCountDto {
    private final int tryCount;

    public TryCountDto(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
