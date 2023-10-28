package racingcar;

public class Car {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void saveCarName(String input) {
        this.name = input;
    }
}
