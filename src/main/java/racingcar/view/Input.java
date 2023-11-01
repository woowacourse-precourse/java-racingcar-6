package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validate.Validate;

public class Input {
    public static final String NAME_DIVISION_WORD = ",";

    private Validate validate = Validate.getInstance();

    public List<String> inputCarNames() {
        List<String> carNames = Arrays.asList(Console.readLine().split(NAME_DIVISION_WORD));

        validate.validateDuplicationCarsName(carNames);
        validate.validateLengthCarsName(carNames);
        validate.validateBlankCarsName(carNames);

        return carNames;
    }

    public int inputRoundNumber() {
        String roundNumber = Console.readLine();

        validate.validateIsNumber(roundNumber);
        validate.validateNegativeNumber(roundNumber);

        return Integer.parseInt(roundNumber);
    }
}
