package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.CarNameRequest;
import racingcar.dto.request.TotalRoundNumberRequest;
import racingcar.exception.UserInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.config.GameConfig.INPUT_NAMES_SEPARATOR;
import static racingcar.exception.errorcode.UserInputErrorCode.INPUT_VALUE_BLANK;
import static racingcar.exception.errorcode.UserInputErrorCode.INPUT_VALUE_NOT_NUMERIC;

public final class InputView {
    private InputView() {

    }

    public static List<CarNameRequest> requestCarNames() {
        final String carNames = Console.readLine();
        validateBlank(carNames);
        return Arrays.stream(carNames.split(INPUT_NAMES_SEPARATOR)).map(CarNameRequest::new).collect(Collectors.toList());
    }

    public static TotalRoundNumberRequest requestTotalRoundNumber() {
        final String totalRound = Console.readLine();
        validateBlank(totalRound);
        validateNumeric(totalRound);
        return new TotalRoundNumberRequest(Integer.parseInt(totalRound));
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
