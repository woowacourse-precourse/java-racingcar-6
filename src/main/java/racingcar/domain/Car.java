package racingcar.domain;

public class Car {

    private String name;
    private StringBuilder distnace;

    public Car(String name) {
        this.name = name;
        this.distnace = new StringBuilder();
    }

    public String getName() {
        return name;
    }
}
