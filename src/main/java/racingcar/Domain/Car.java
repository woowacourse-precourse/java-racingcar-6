package racingcar.Domain;

public class Car {
    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public void driveForward(int drivedistance) {
        this.location += drivedistance;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
