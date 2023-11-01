package racingcar;

public class Car {


    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public void move() {
        this.position++;
    }

    @Override
    public String toString() {
        String outputBuilder = this.carName + " : "
                + "-".repeat(Math.max(0, this.position));
        return outputBuilder;
    }

}
