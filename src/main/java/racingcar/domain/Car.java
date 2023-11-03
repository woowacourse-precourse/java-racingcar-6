package racingcar.domain;

public class Car {

    private String name;
    private StringBuilder location;

    public Car(String name) {
        this.name = name;
        this.location = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public StringBuilder getLocation() {
        return location;
    }

    public void addLocation() {
        this.location.append("-");
    }

    @Override
    public String toString() {
        return name + " : " + location.toString() + "\n";
    }
}
