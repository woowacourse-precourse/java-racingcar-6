package domain;

import util.RandomGenerator;

public class RacingCar {

    private static final int MOVE_FORWARD_MINIMUM = 4;

    private String name;
    private String location;

    public RacingCar(String name) {
        this.name = name;
        this.location = "";
    }

    public boolean isMoveForward(int randomNumber) {
        if (MOVE_FORWARD_MINIMUM <= randomNumber) {
            return true;
        }
        return false;
    }

    public void moveForward() {
        this.location += "-";
    }

    public String getLocation() {
        return this.location;
    }

}
