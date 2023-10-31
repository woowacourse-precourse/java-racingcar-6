package racingcar;

public class Car {

    private String name;
    private int motionState;
    private int posotion;

    public Car(String name) {
        this.name = name;
        this.motionState = -1;
        this.posotion = 0;
    }

    public void setMotionState(int motionState) {
        this.motionState = motionState;
    }

    public void plusOnePosition() {
        posotion++;
    }

    public int getMotionState() {
        return motionState;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return posotion;
    }
}
