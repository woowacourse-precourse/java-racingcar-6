package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    final String MARK_FOR_FORWARD = "-";
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

        return Randoms.pickNumberInRange(CarConstants.START_RANDOM.getConst(),
                CarConstants.END_RANDOM.getConst());
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

    final void validateNameLength(String carName) {
        if (!(carName.length() <= CarConstants.LENGTH_CAR_NAME.getConst())) {
            errorType = ErrorMessages.OVER_LENGTH_CARNAME;
            throw new IllegalArgumentException(CarConstants.LENGTH_CAR_NAME.getConst() + errorType.getDescription());
        }
    }

    final void validateNameSpace(String carName) {
        if (carName.contains(" ")) {
            errorType = ErrorMessages.CONTAIN_WHITE_SPACE;
            throw new IllegalArgumentException(errorType.getDescription());
        }
    }
}
