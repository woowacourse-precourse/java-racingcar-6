package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private int movement;

    public RacingCar(String name) {
        this.name = name;
        this.movement = 0;
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }

    private void setMovement(int movement) {
        this.movement = movement;
    }

    public boolean move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            setMovement(getMovement() + 1);
            return true;
        }
        
        return false;
    }
}
