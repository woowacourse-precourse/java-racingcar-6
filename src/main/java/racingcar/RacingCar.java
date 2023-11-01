package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    public static final String DISTANCE = "-";
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int MOVEMENT_THRESHOLD = 4;
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
        int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);

        if (randomNumber >= MOVEMENT_THRESHOLD) {
            setMovement(getMovement() + DISTANCE);
            return true;
        }

        return false;
    }
}
