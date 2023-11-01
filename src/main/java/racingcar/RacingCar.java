package racingcar;

import static racingcar.ErrorMessage.CAR_NAME_OVER_MAX_LENGTH;
import static racingcar.PrintMessage.LOCATION_SIGN;
import static racingcar.PrintMessage.RESULT_OF_RACING_CAR_FORMAT;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private static final Integer PICK_NUMBER_START_RANGE = 0;
    private static final Integer PICK_NUMBER_END_RANGE = 9;
    private static final Integer CONDITION_OF_MOVING_FORWARD = 4;
    private static final Integer NAME_MAX_LENGTH = 5;

    private String name;
    private Integer location;

    public RacingCar(String name) {
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

    private void validateCarNameLength(String carName) {
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
