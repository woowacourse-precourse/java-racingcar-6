package racingcar.model.car;

import racingcar.constant.message.Message;
import racingcar.service.Accelerator;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

public class Car {

    protected final String name;
    protected Long currentPosition;

    private Car(String name, Long currentPosition) {
        validate(name);
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public static Car ofStartingPoint(String name) {
        return new Car(name, 0L);
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

    //TODO: 게터 지양
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(Message.NAME_POSITION_SEPARATOR);
        for (long i = 0; i < this.currentPosition; i++) {
            stringBuilder.append(Message.MARK);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car car)) {
            return false;
        }
        return this.currentPosition.equals(car.currentPosition);
    }
}
