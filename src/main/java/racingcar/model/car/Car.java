package racingcar.model.car;

import racingcar.constant.message.Message;
import racingcar.service.Accelerator;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

public class Car {

    private final String name;
    private Integer currentPosition;

    private Car(String name, Integer currentPosition) {
        validate(name);
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public static Car ofStartingPoint(String name) {
        return new Car(name, 0);
    }

    public void move(Accelerator accelerator) {
        if (accelerator.canMoveForward()) {
            currentPosition++;
        }
    }

    private void validate(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }

    public String getName() {
        return this.name;
    }

    public Integer getCurrentPosition() {
        return this.currentPosition;
    }

    public Boolean hasSamePosition(Integer position) {
        return this.currentPosition.equals(position);
    }

    @Override
    public String toString() {
        return this.name + Message.MARK.repeat(this.currentPosition);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car car)) {
            return false;
        }
        return this.equals(car);
    }
}
