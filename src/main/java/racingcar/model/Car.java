package racingcar.model;

public class Car {
    private String name;
    private int forwardDistance;

    public Car(String name) {
        // 생성자
    }

    public void moveOnRandomCondition() {
        // NumberGenerator의 random Method를 통해 난수 생성 후
        // forwardDistance를 증가시킨다.
    }

    public String getName() {
        return this.name;
    }

    public int getForwardDistance() {
        return this.forwardDistance;
    }
}
