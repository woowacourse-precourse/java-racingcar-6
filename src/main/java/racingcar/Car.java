package racingcar;

public class Car {
    private String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public void go() {
        status ++;
    }
}
