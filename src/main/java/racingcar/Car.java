package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    final String MARK_FOR_FORWARD = "-";
    private int forwardCount;
    private String presentCondition;
    private ErrorMessages errorType;

    public Car(String carName) {
        setCarName(carName);

        this.forwardCount = 0;
        this.presentCondition = "";
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(CarConstants.START_RANDOM.getConst(),
                CarConstants.END_RANDOM.getConst());
    }

    private boolean validateName(String carName) {
        if (!(carName.length() <= CarConstants.LENGTH_CAR_NAME.getConst())) {
            errorType = ErrorMessages.OVER_LENGTH_CARNAME;
            throw new IllegalArgumentException(CarConstants.LENGTH_CAR_NAME.getConst() + errorType.getDescription());
        }

        if (carName.contains(" ")) {
            errorType = ErrorMessages.CONTAIN_WHITE_SPACE;
            throw new IllegalArgumentException(errorType.getDescription());
        }

        return true;
    }

    public void runCar() {
        if (getRandomNumber() >= CarConstants.TRIGGER_MINIMUM_FORWARD.getConst()) {
            increaseForwardCount(CarConstants.INCREASE_NUM_FORWARD.getConst());
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

    public void setCarName(String name) {
        if (validateName(name)) {
            this.carName = name;
        }
    }

    public String getCarName() {
        return carName;
    }
}
