package racingcar.car;

public class Car {
    private String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
