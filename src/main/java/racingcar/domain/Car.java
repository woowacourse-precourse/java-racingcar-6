package racingcar.domain;

public record Car(String name, int forwardStep) {

    public static Car of(String name) {
        return new Car(name, 0);
    }
}
