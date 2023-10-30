package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.GameRuleNumbers;

public class Car {
    private String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void moveOrStop() {
        int randomNumber = Randoms.pickNumberInRange(GameRuleNumbers.RANDOM_NUMBER_MIN,
                GameRuleNumbers.RANDOM_NUMBER_MAX);
        if (randomNumber >= GameRuleNumbers.FORWARD_CONDITION) {
            position++;
        }
    }
}
