package racingcar.domain;

public record Lap(int count) {

    public Lap {
        if (count < 0) {
            throw new IllegalArgumentException("lap은 0보다 작을 수 없습니다.");
        }
    }

    public Lap nextLap() {
        return new Lap(count + 1);
    }

}
