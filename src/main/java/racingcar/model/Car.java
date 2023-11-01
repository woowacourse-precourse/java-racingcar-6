package racingcar.model;

public class Car {
    private final CarName name;
    private int location;

    public Car(String name) {
        this.name = new CarName(name);
        this.location = 0;
    }

    public String getName() {
        return this.name.name();
    }

    public void goOrStop(int i) {
        if (i > 3) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
