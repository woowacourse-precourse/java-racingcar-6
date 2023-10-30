package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MINIMUM_MOVABLE_NUMBER = 4;

    private String name;
    private String route;

    public Car(String name) {
        this.name = name;
        this.route = "";
    }

    public String getName() {
        return this.name;
    }

    public String getRoute() {
        return this.route;
    }

    public void moveForward() {
        route += "-";
    }

    public boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
        if (randomNumber >= MINIMUM_MOVABLE_NUMBER) {
            return true;
        }
        return false;
    }
}