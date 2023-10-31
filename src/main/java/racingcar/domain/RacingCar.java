package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    public static String SYMBOL = "-";
    public static int LOWER_BOUND_OF_NUMBER = 0;
    public static int UPPER_BOUND_OF_NUMBER = 9;
    public static int MOVABLE_VALUE = 4;
    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        if (canMove()) {
            this.distance++;
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(LOWER_BOUND_OF_NUMBER, UPPER_BOUND_OF_NUMBER) >= MOVABLE_VALUE;
    }

    public void printCurrentDistance() {
        String graph = SYMBOL.repeat(this.distance);
        String result = String.format("%s : %s", this.name, graph);
        System.out.println(result);
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}
