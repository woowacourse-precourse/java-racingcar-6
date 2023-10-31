package racingcar.config;

import racingcar.model.car.CarMoveRule;
import racingcar.model.car.RandomCarMoveRule;

public class CarMoveRuleConfig {

    private static CarMoveRule currentRule;
    private static CarMoveRule randomRule;

    public static CarMoveRule getCurrentCarMoveRule() {
        if (currentRule == null) {
            setDefault();
        }
        return currentRule;
    }

    private static void setDefault() {
        currentRule = getRandomCarMoveRule();
    }

    public static void setCustomCarMoveRule(CarMoveRule carMoveRule) {
        currentRule = carMoveRule;
    }

    private static CarMoveRule getRandomCarMoveRule() {
        if (randomRule == null) {
            randomRule = new RandomCarMoveRule();
        }
        return randomRule;
    }
}
