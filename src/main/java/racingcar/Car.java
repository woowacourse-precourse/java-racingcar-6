package racingcar;

public class Car {
    private String name;
    private String status;

    public Car(String name) {
        this.name = name;
        this.status = "";
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}