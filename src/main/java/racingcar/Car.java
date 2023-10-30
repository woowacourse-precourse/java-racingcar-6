package racingcar;

public final class Car {
    private String name;
    private Car(final String givenName) {
        this.name = givenName;
    }
    public static Car applyName(String givenName) {
        return new Car(givenName);
    }

    @Override
    public String toString() {
        return name;
    }
}
