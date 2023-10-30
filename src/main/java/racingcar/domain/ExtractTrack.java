package racingcar.domain;

public record ExtractTrack(int value) {
    public ExtractTrack {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }


    public ExtractTrack consumerCount() {
        return new ExtractTrack(value - 1);
    }

    public boolean isCompleted() {
        return value == 0;
    }

}
