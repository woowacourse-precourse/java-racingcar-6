package racingcar;

public class Car {
    private String name;
    private StringBuilder status;

    public Car(String name) {
        this.name = name;
        this.status = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status.toString();
    }
}