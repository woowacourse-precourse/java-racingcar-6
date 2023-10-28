package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    public int randomNumber;
    public int distance;

    public RacingCar(String name) {
        this.name = name;
    }

    public void makeRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    public void goOrStop() {
        if (this.randomNumber >= 4) {
            this.distance++;
        }
    }
}
