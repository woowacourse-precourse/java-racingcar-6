package racingcar;

import racingcar.utils.Constants;

public class Car {
    private Name name;
    private Location location;

    public Car(String name) {
        this.name = new Name(name);
        this.location = new Location();
    }

    public void tryMove(int fuel) {
        if (canMove(fuel)) {
            location.move();
        }
    }

    private boolean canMove(int fuel) {
        return fuel >= Constants.MINIMUM_MOVE_FUEL_LEVEL;
    }

    public String getName() {
        return name.getValue();
    }

    public int getLocation() {
        return location.getValue();
    }
}