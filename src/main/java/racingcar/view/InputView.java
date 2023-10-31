package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.CarNameRequest;
import racingcar.dto.request.TotalRoundNumberRequest;
import racingcar.exception.UserInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.exception.errorcode.UserInputErrorCode.INPUT_VALUE_BLANK;
import static racingcar.exception.errorcode.UserInputErrorCode.INPUT_VALUE_NOT_NUMERIC;

public final class InputView {
    private static final String CAR_NAMES_INPUT_SEPARATOR = ",";

    private InputView() {

    }

    public static List<CarNameRequest> requestCarNames() {
        final String carNames = readLineAndValidateBlank();
        return Arrays.stream(carNames.split(CAR_NAMES_INPUT_SEPARATOR)).map(CarNameRequest::new).collect(Collectors.toList());
    }

    public static TotalRoundNumberRequest requestTotalRoundNumber() {
        final String totalRound = readLineAndValidateBlank();
        validateNumeric(totalRound);
        return new TotalRoundNumberRequest(Integer.parseInt(totalRound));
    }

    private static String readLineAndValidateBlank() {
        final String input = Console.readLine();
        validateBlank(input);
        return input;
    }

    private static void validateBlank(final String input) {
        if (input.isBlank()) {
            throw new UserInputException(INPUT_VALUE_BLANK);
        }
    }

    private static void validateNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new UserInputException(INPUT_VALUE_NOT_NUMERIC);
        }
    }
}
