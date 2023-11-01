package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String CAR_NAMES_DELIMITER = ",";

    public static List<Car> inputCarNames() {
        return getCarNames();
    }

    public static List<Car> getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(CAR_NAMES_DELIMITER);

        for (String carName : carNames) {
            Validator.validateCarName(carName);
        }
        Validator.validateDuplicate(carNames);

        return TypeConverter.convertStringArrayToCarList(carNames);
    }

    public static int inputRound() {
        String input = Console.readLine();
        return Validator.validateRound(input);
    }
}
