package racingcar.domain;

public class Car {

    private final String name;
    private Integer distance = 0;
    private String mileage = "";

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.mileage;
    }
}
