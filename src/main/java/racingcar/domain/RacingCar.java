package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    public final String name;
    public int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    private void move() {
        this.position++;
    }

    public void tryMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            move();
        }
    }

}
