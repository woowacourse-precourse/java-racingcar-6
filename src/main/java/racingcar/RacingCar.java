package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private String movement;

    public RacingCar(String name) {
        this.name = name;
        this.movement = "";
    }

    public String getName() {
        return name;
    }

    public String getMovement() {
        return movement;
    }

    private void setMovement(String movement) {
        this.movement = movement;
    }

    public boolean move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            setMovement(getMovement() + "-");
            return true;
        }

        return false;
    }
}
