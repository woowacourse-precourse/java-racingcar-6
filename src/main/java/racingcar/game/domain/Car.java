package racingcar.game.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.RandomUtil;
import racingcar.game.validation.CarValidator;
import racingcar.game.validation.Validator;

import static racingcar.game.RandomUtil.*;

public class Car {

    private static final Validator VALIDATOR = new CarValidator();

    private final String name;
    private final StringBuilder forwardState;

    private Car(String name) {
        this.name = name;
        this.forwardState = new StringBuilder();
    }

    public static Car create(String name) {
        VALIDATOR.execute(name);

        return new Car(name);
    }

    public void tryForward() {
        if (isRandomBiggerThanEqual(4)) {
            forwardState.append('-');
        }
    }

    public String getCarState() {
        return name + " : " + forwardState;
    }

    public String getName() {
        return name;
    }

    public StringBuilder getForwardState() {
        return forwardState;
    }

}
