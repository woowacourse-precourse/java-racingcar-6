package racingcar;

public record CarName(String name) {

    public CarName {
        throwIfInvalidName(name);
    }

    private void throwIfInvalidName(String name) {

    }

    @Override
    public String toString() {
        return name;
    }
}
