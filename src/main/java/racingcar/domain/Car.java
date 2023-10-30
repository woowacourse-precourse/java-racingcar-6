package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    private int randomNumber;
    private String score;

    public Car() {
        this.randomNumber = 0;
        this.score = "";
    }


    public String advance(int num) {
        if (num >= 4) {
            score += "-";
        }
        return score;
    }

    public int extract() {
        return pickNumberInRange(0, 9);
    }
}
