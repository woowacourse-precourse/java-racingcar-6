package racingcar.domain;

public class Car {
    private String name;
    private int movedCount;

    Accelerator accelerator = new Accelerator();

    public Car(String name) {
        this.name = name;
        this.movedCount = 0;
    }

    public void move() {
        if (accelerator.press()) {
            movedCount++;
        }
    }
}
