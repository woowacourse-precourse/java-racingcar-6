package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    final int LENGTH_CAR_NAME = 5;
    final int START_RANDOM_RANGE = 0;
    final int END_RANDOM_RANGE = 9;
    final int TRIGGER_MINIMUM_FORWARD = 4;
    final String MARK_FOR_FORWARD = "-";
    final int INCREASE_NUM_FORWARD = 1;
    private int forwardCount;
    private String presentCondition;
    private ErrorMessages errorType;

    public Car(String carName) {
        validateNameSpace(carName);
        validateNameLength(carName);

        this.carName = carName;
        this.forwardCount = 0;
        this.presentCondition = "";
    }

    public String getCarName() {
        return carName;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_RANGE, END_RANDOM_RANGE);
    }

    public void runCar() {
        if (getRandomNumber() >= TRIGGER_MINIMUM_FORWARD) {
            increaseForwardCount(INCREASE_NUM_FORWARD);
            presentCondition += MARK_FOR_FORWARD;
        }

        System.out.println(getPresentCondition());
    }

    public void increaseForwardCount(int increaseNum) {
        forwardCount += increaseNum;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public String getPresentCondition() {
        return getCarName() + " : " + presentCondition;
    }

    final void validateNameLength(String carName) {
        if (!(carName.length() <= LENGTH_CAR_NAME)) {
            errorType = ErrorMessages.OVER_LENGTH_CARNAME;
            throw new IllegalArgumentException(LENGTH_CAR_NAME + errorType.getDescription());
        }
    }

    final void validateNameSpace(String carName) {
        if (carName.contains(" ")) {
            errorType = ErrorMessages.CONTAIN_WHITE_SPACE;
            throw new IllegalArgumentException(errorType.getDescription());
        }
    }
}
