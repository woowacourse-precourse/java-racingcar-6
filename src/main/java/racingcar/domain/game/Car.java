package racingcar.domain.game;

import racingcar.domain.dto.CarDto;
import racingcar.util.NumberPicker;

public class Car {
    private final String name;
    private int position = 0;

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

    public CarDto moveOnce(NumberPicker numberPicker) {
        if (numberPicker.pick() >= 4) {
            position++;
        }
        return new CarDto(name, position);
    }
}
