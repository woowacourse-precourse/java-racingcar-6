package racingcar.domain;

import racingcar.domain.dto.CarDTO;
import static racingcar.util.constant.NumberConstant.*;

public class Car {

    private final String name;
    private int position;


    public Car(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move(int randomNumber) {
        if(randomNumber >= MOVE_CONDITION) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }
}
