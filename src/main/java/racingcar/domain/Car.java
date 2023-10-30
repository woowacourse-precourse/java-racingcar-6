package racingcar.domain;

public class Car {
    private String name;
    private int current;

    public Car(String name, int current) {
        this.name = name;
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void forward(int forward) {
        this.current++;
    }
}
