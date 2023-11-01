package racingcar;

public class Car {

    private String name;
    private int motionState;
    private int position;

    public Car(String name) {
        this.name = name;
        this.motionState = -1;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getMotionState() {
        return motionState;
    }

    public void setMotionState(int motionState) {
        this.motionState = motionState;
    }

    public int getPosition() {
        return position;
    }

    public void plusOnePosition() {
        position++;
    }
}
