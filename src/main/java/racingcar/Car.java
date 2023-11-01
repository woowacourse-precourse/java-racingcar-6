package racingcar;


public class Car {
    private String carName;
    private int carLocation;

    public Car(String carName) {
        this.carName = carName;
        this.carLocation = 0;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarLocation() {
        return this.carLocation;
    }

    public void setCarLocation(int number) {
        this.carLocation = number;
    }

    public void moveCar() {
        this.carLocation += 1;
    }
}
