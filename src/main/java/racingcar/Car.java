package racingcar;

public class Car {

    private String carName;
    private int movingCount;

    public Car(String carName, int movingCount) {
        this.carName = carName;
        this.movingCount = movingCount;
        checkCarNameLength();
    }

    public void checkCarNameLength() {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자 초과인 잘못된 입력입니다.");
        }
    }

    public int getMovingCount() {
        return movingCount;
    }

    public String getCarName() {
        return carName;
    }
}
