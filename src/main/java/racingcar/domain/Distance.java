package racingcar.domain;

record Distance(
        int value
) {
    Distance {
        if (value < 0) {
            throw new IllegalArgumentException("거리는 0보다 작을 수 없습니다.");
        }
    }
    public Distance increase(Distance target) {
        return new Distance(value + target.value);
    }
    public static Distance ZERO = new Distance(0);
}
