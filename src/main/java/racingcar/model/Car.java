package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        this.position++;
    }
}
