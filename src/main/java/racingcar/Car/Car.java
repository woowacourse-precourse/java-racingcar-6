package racingcar.Car;


public class Car {
    private String name;

    public  Car (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Car{name='" + name + "'}";
    }
}
