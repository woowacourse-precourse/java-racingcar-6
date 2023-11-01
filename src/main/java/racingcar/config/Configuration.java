package racingcar.config;

import static racingcar.constant.DefaultValidatorConstant.DEFAULT_CAR_NAME_DUPLICATION_POLICY;
import static racingcar.constant.DefaultValidatorConstant.DEFAULT_MAX_CAR;
import static racingcar.constant.DefaultValidatorConstant.DEFAULT_MAX_EXECUTION_COUNT;

import racingcar.Game;
import racingcar.input.ConsoleInput;
import racingcar.input.Input;
import racingcar.output.ConsoleOutput;
import racingcar.output.Output;
import racingcar.validator.Validator;

public class Configuration {

    public static Game game() {
        return new Game(input(), output());
    }

    public static Input input() {
        return new ConsoleInput(validator());
    }

    public static Output output() {
        return new ConsoleOutput();
    }

    //Validator 커스텀 가능
    public static Validator validator() {
        Validator validator = new Validator();
        validator.setMaxCar(DEFAULT_MAX_CAR);
        validator.setMaxExecutionCount(DEFAULT_MAX_EXECUTION_COUNT);
        validator.setAllowCarNameDuplication(DEFAULT_CAR_NAME_DUPLICATION_POLICY);
        return validator;
    }
}
