package racingcar.domain;

public class Car {
    private String carName;
    private int count;

    public Car(String carName) {
        this.carName = carName;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCarName() {
        return carName;
    }
}