package racingcar.domain.game;

public class Car {
    private final String name;
    private final int position = 0;

    private Car(String name) {
        validateNumberLength(name);
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    private void validateNumberLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
