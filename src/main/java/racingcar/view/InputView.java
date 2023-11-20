package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.OutputFormat;

import java.util.Arrays;
import java.util.List;

import static racingcar.message.ErrorMessage.NOT_NUMBERS_ERROR;
import static racingcar.message.ErrorMessage.INCLUDE_NULL_ERROR;
import static racingcar.message.GuideMessage.INPUT_NAME_GUIDE;
import static racingcar.message.GuideMessage.INPUT_RACE_NUM_GUIDE;

public class InputView {
    private final InputValidator inputValidator;
    private static final String NAME_SPLIT_FORMAT = ",";

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public List<String> inputCarName() {
        System.out.println(INPUT_NAME_GUIDE.getMessage());
        List<String> cars = Arrays.asList(Console.readLine().trim().split(NAME_SPLIT_FORMAT));
        if (!inputValidator.nameSplitValid(cars)) {
            System.out.println(INCLUDE_NULL_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
        return cars;
    }

    public int inputRacingNum() {
        System.out.println(INPUT_RACE_NUM_GUIDE.getMessage());
        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBERS_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
