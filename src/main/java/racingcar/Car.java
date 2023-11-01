package racingcar;

public class Car {

    private String name;
    private int status = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void updateStatus() {
        status++;
    }
}
