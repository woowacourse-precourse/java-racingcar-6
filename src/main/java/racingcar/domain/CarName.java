package racingcar.domain;

public record CarName(String value) {
    public CarName {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException();
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
