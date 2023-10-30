package racingcar.domain;

public record CarName(String name) {
    public CarName {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
