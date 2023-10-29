package racingcar.Model;

public class Car {
    private String carName;
    private int stepCount = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getName(){
        return this.carName;
    }

    public int getStepCount(){
        return this.stepCount;
    }

    public void plusStepCount(){
        this.stepCount = this.stepCount + 1;
    }
}
