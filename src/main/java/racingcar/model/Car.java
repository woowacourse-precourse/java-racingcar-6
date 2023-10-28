package racingcar.model;

import racingcar.util.BlankValidator;
import racingcar.util.MaxLengthValidator;
import racingcar.util.NameValidator;
import racingcar.util.Validate;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        NameValidator.createNameValidator().validate(name);
        MaxLengthValidator.createMaxLengthValidator().validate(name);
        BlankValidator.createBlankValidator().validate(name);
        this.name = name;
        this.position = 0;
    }

}
