package racingcar;

public class Car {

    private String name;
    private int motionState;

    public Car(String name) {
        this.name = name;
        this.motionState = -1;
    }

    public void setMotionState(int motionState) {
        this.motionState = motionState;
    }

}
