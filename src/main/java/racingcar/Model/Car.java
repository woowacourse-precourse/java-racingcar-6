package racingcar.Model;

public class Car {
    String name;
    String position;

    public Car(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
