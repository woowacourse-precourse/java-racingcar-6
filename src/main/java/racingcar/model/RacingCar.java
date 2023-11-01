package racingcar.model;

import static racingcar.constant.ErrorMessage.CAR_NAME_OVER_MAX_LENGTH;
import static racingcar.constant.PrintMessage.LOCATION_SIGN;
import static racingcar.constant.PrintMessage.RESULT_OF_RACING_CAR_FORMAT;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private static final Integer PICK_NUMBER_START_RANGE = 0;
    private static final Integer PICK_NUMBER_END_RANGE = 9;
    private static final Integer CONDITION_OF_MOVING_FORWARD = 4;
    private static final Integer NAME_MAX_LENGTH = 5;

    private final String name;
    private int location;

    public RacingCar(final String name) {
        validateCarNameLength(name);
        this.name = name;
        location = 0;
    }

    public void moveOrStay() {
        if (canMoveForward()) {
            location++;
        }
    }

    private boolean canMoveForward() {
        return createRandomNumber() >= CONDITION_OF_MOVING_FORWARD;
    }

    private Integer createRandomNumber() {
        return Randoms.pickNumberInRange(PICK_NUMBER_START_RANGE, PICK_NUMBER_END_RANGE);
    }

    private void validateCarNameLength(final String carName) {
        if(carName.length() > NAME_MAX_LENGTH){
            throw new IllegalArgumentException(CAR_NAME_OVER_MAX_LENGTH);
        }
    }

    @Override
    public String toString() {
        return String.format(RESULT_OF_RACING_CAR_FORMAT, name, LOCATION_SIGN.repeat(location));
    }

    public Integer getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
