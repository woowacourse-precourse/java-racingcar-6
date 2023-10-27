package racingcar.domain;

record Distance(
        int value
) {
    public static Distance zero() {
        return new Distance(0);
    }
}
