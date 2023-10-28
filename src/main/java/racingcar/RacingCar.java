package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private Integer movedDistance;

    public RacingCar(String name) {
        this.name = name;
        this.movedDistance = 0;
    }

    public void tryMoving() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            movedDistance += 1;
        }
    }

    public void printResult() {

    }

    public Integer getMovedDistance() {
        return movedDistance;
    }
}
