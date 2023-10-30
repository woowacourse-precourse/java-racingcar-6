package racingcar.model;

public class Car {
    private CarName carName;
    private int position;

    private Car(String name) {
        this.carName = new CarName(name);
        this.position = 0;
    }

    public static Car from(String carName) {
        return new Car(carName);
    }

    public void moveForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.carName.getName();
    }
}
