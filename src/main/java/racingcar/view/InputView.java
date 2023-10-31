package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.CarNameValidator;
import racingcar.utils.GameCountValidator;

public class InputView {

    public String inputGameCount() {
        String gameCount = Console.readLine();
        GameCountValidator.validatePositiveDigitAnInRangeGameCount(gameCount);
        return gameCount;
    }

    public List<String> inputCarNames() {
        String carNames = Console.readLine();
        CarNameValidator.validateMultipleCarName(carNames);

        List<String> convertedCarNames = convertToList(carNames);
        for (String carName : convertedCarNames) {
            CarNameValidator.validateCarName(carName);
        }

        CarNameValidator.validateDuplicateCarName(convertedCarNames);

        return convertedCarNames;
    }

    private List<String> convertToList(String carNames) {
        return Arrays.stream(carNames.split(CarNameValidator.MULTIPLE_CAR_NAME_DELIMITER))
            .toList();
    }
}
