package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.CarNameRequest;
import racingcar.exception.UserInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.config.GameConfig.INPUT_NAMES_SEPARATOR;
import static racingcar.exception.errorcode.UserInputErrorCode.INPUT_VALUE_BLANK;

public final class InputView {
    private InputView() {

    }

    public static List<CarNameRequest> requestCarNames() {
        final String carNames = Console.readLine();
        validateBlank(carNames);
        return Arrays.stream(carNames.split(INPUT_NAMES_SEPARATOR)).map(CarNameRequest::new).collect(Collectors.toList());
    }

    private static void validateBlank(final String input) {
        if (input.isBlank()) {
            throw new UserInputException(INPUT_VALUE_BLANK);
        }
    }
}
