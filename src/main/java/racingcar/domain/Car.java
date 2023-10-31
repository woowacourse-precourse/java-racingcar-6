package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    private String name;
    private String score;

    public Car() {
        this.score = "";
    }

    public Car(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

}
