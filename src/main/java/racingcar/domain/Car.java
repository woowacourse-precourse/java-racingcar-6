package racingcar.domain;

public class Car {
    private final String name;
    private StringBuilder distance; //long 으로 리팩토링

    public Car(String name, StringBuilder distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car createCar(String name, StringBuilder distance) {
        return new Car(name, distance);
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance.toString();
    }

    public void move() {
        distance.append("-");
    }
}
