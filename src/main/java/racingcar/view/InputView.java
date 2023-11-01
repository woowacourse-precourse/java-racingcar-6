package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.TypeConverter;
import racingcar.util.Validator;
import racingcar.model.Car;

public class InputView {
    private static final String CAR_NAMES_DELIMITER = ",";

    public static List<Car> inputCarNames() {
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
