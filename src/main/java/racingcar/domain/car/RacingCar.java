package racingcar.domain.car;

import racingcar.domain.car.validate.NameLengthValidator;
import racingcar.domain.result.RacingCarResult;

public class RacingCar {

    private static final int START_LOCATION = 0;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private Integer location;

    public RacingCar(String name) {
        validate(name);
        this.name = name;
        this.location = START_LOCATION;
    }

    public void move(Integer commandNumber) {
        if (commandNumber >= MOVE_CONDITION) {
            this.location++;
        }
    }

    public RacingCarResult toResult() {
        return new RacingCarResult(name, location);
    }

    private void validate(String name) {
        NameLengthValidator.validate(name);
    }
}
