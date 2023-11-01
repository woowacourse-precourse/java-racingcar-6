package racingcar.model;

public class Car {

    private String carName;
    private int moveCnt;

    public Car(String carName) {
        this.carName = carName;
        this.moveCnt = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public void moveCar() {
        moveCnt++;
    }
}
