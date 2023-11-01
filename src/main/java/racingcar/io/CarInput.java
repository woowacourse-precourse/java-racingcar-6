package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.CarUtil;
import racingcar.validator.CarInputValidator;
import racingcar.validator.RoundInputValidator;

public class CarInput {
    public static String[] getCarNames() {
        String[] carNames = Console.readLine().split(CarUtil.CAR_NAME_SPLIT);
        CarInputValidator.validateCars(carNames);
        return carNames;
    }

    public static int getRound() {
        String round = Console.readLine();
        RoundInputValidator.checkRoundNumberFormat(round);
        return Integer.parseInt(round);
    }
}
