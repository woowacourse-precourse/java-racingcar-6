package racingcar.domain;

public class Car {

    private final String name;
    private String position;

    public Car(String name) {

        this.name = name;
        this.position = "";
    }

    public static Car makeCar(String name) {

        return new Car(name);
    }

    public void move() {

        this.position += "-";
    }

    public String getName() {

        return name;
    }

    public String getPosition() {

        return position;
    }
}
