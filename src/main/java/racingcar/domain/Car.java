package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constant;

public class Car {
    String name;
    String score;

    public Car(String name, String score){
        this.name = name;
        this.score = score;
    }

    public void addScore() {
        this.score = score+ Constant.POSITION_SYMBOL;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public void movePosition(){
        if (Randoms.pickNumberInRange(Constant.RANDOM_MINIMUM, Constant.RANDOM_MAXIMUM) >= Constant.RANDOM_BOUNDARY) {
            addScore();
        }
    }
}