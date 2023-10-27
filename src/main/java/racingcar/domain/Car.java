package racingcar.domain;

import static racingcar.view.NameConstraints.MAX_NAME_LENGTH;

public class Car {

    private final String name;
    private final int position;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH.getValue() || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, "
                    + MAX_NAME_LENGTH.getValue() + "자 이하만 가능합니다.");
        }
    }
}
