package racingcar.domain;

public class Car {

    private int carNum;
    private String carName;
    private int goCount;

    public Car(int carNum, String carName, int goCount) {
        this.carNum = carNum;
        this.carName = carName;
        this.goCount = goCount;
    }

    public int getCarNum() {
        return carNum;
    }

    public String getCarName() {
        return carName;
    }

    public int getGoCount() {
        return goCount;
    }

    public void goAhead() {
        this.goCount++;
    }
}
