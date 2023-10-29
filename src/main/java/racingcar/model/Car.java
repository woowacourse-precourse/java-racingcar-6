package racingcar.model;

public class Car {
    private static final int FORWARD_STEP = 1;
    private static final int INITIAL_FORWARD_COUNT = 0;
    private String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = INITIAL_FORWARD_COUNT;
    }

    public void upForwardCount() {
        forwardCount += FORWARD_STEP;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public String getName() {
        return name;
    }

}
