package racingcar.domain;

import racingcar.validation.CarNameValidator;

public class Car {
    private final String name;
    private int position;

    public Car(String name){
        CarNameValidator.checkValidLength(name);
        this.name = name;
        this.position = 0;
    }
}
