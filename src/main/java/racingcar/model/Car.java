package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private Integer moveDistance;

    private static final int MIN_MOVE_CONSTRAINTS = 4;
    private static final int RANDOM_NUMBER_RANGE_START = 0;
    private static final int RANDOM_NUMBER_RANGE_END = 9;

    public Car(String inputName, Integer inputScore) {

        exceptCarNameValidate(inputName);

        this.carName = inputName;
        this.moveDistance = inputScore;
    }

    public void move() {
        if (canMove()) {
            this.moveDistance++;
        }
    }


    public CarData getData() {
        return new CarData(this.carName, this.moveDistance);
    }

    private boolean canMove() {
        return MIN_MOVE_CONSTRAINTS <= Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END);
    }

    public void exceptCarNameValidate(String carName) {
        if (Validator.validateMaxNameLength(carName)) {
            throw new IllegalArgumentException("입력값이 최대 길이를 초과 했습니다.");
        }
        if (Validator.validateNameIsNull(carName)) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
    }

}
