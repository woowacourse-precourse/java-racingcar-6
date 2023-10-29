package racingcar.domain;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    protected Car(){
    }

    public String getName() {
        return name;
    }
}
