package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
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
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void printCurrentDistance() {
        String graph = "-".repeat(this.distance);
        String result = String.format("%s : %s", this.name, graph);
        System.out.println(result);
    }
}
