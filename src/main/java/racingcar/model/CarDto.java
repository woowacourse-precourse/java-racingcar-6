package racingcar.model;

import racingcar.constant.ValidatorConstant;
import racingcar.utils.CarNameValidator;

public class CarDto {
    private final String name;
    private int position = 0;

    public CarDto(String name) {
        CarNameValidator.validateCarName(name);
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= ValidatorConstant.RANDOM_NUMBER) {
            position++;
        }
    }
    public String getName() {
        return name;
    }

    public int getDistance() {
        return position;
    }


}