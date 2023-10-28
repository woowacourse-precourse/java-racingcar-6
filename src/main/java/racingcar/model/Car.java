package racingcar.model;

public class Car {
    private String carName;
    private int forwardSteps;

    public Car(String carName){
        this.carName =carName;
        this.forwardSteps = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardSteps() {
        return forwardSteps;
    }

    public void setForwardSteps(int forwardSteps) {
        this.forwardSteps = forwardSteps;
    }

    @Override
    public String toString() {
        return "Car(" + carName + ',' + forwardSteps + ')';
    }
}
