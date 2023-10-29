package racingcar;

public class Car {

    private String name;
    private Integer forwardCount;

    private static final int DEFAULT_FORWARD_COUNT = 0;

    public Car(String name) {
        this.name = name;
        this.forwardCount = DEFAULT_FORWARD_COUNT;
    }

    public boolean isEqualName(String inputName) {
        return inputName.equals(name);
    }

    public void moveForward() {
        forwardCount++;
    }

    public void printCarName() {
        System.out.println(name + " : ");
    }

    public void printForwardCount() {
        System.out.println("-".repeat(forwardCount));
    }

}
