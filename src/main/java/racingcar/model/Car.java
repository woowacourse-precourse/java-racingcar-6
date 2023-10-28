package racingcar.model;

public class Car {
     private String carName;
     private int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
