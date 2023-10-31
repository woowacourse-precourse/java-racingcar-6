package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private static final Integer PICK_NUMBER_START_RANGE = 0;
    private static final Integer PICK_NUMBER_END_RANGE = 9;

    private String name;
    private Integer location;

    public RacingCar(String name) {
        this.name = name;
        location = 0;
    }

    private Integer createRandomNumber() {
        return Randoms.pickNumberInRange(PICK_NUMBER_START_RANGE, PICK_NUMBER_END_RANGE);
    }
}
