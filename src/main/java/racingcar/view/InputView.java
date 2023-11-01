package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.TryCount;
import racingcar.util.ExceptionMessage;

public class InputView {
    private static final String CAR_NAME_SEPARATOR = ",";

    public List<String> inputCarNames() {
        OutputView.printInputCarNamesMessage();
        List<String> carNames = splitCarName(Console.readLine());
        return trimCarName(carNames);
    }

    public TryCount inputTryCount() {
        OutputView.printInputTryCountMessage();
        return convertTryCount(Console.readLine());
    }

    private List<String> splitCarName(String carNamesInput) {
        return List.of(carNamesInput.split(CAR_NAME_SEPARATOR));
    }

    private List<String> trimCarName(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private TryCount convertTryCount(String tryCountInput) {
        try {
            return new TryCount(Integer.parseInt(tryCountInput));
        } catch (NumberFormatException | InputMismatchException e) {
            throw new IllegalArgumentException(ExceptionMessage.GAME_TRY_COUNTS_FORMAT);
        }
    }
}
