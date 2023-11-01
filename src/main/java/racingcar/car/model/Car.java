package racingcar.car.model;

public class Car {

    private String name;

    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void increasePosition() {
        this.position += 1;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.position;
    }

}
