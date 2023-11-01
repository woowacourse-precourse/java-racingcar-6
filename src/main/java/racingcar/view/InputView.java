package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.CarNameValidator;
import racingcar.utils.GamePlayCountValidator;

public class InputView {

    public int inputGamePlayCount() {
        String gamePlayCount = Console.readLine();
        GamePlayCountValidator.validatePositiveDigitAnInRangeGamePlayCount(gamePlayCount);
        return Integer.parseInt(gamePlayCount);
    }

    public List<String> inputCarNames() {
        String carNames = Console.readLine();
        return getValidatedCarNames(carNames);
    }

    private List<String> getValidatedCarNames(String carNames) {
        CarNameValidator.validateMultipleCarName(carNames);

        List<String> convertedCarNames = convertToList(carNames);
        for (String carName : convertedCarNames) {
            CarNameValidator.validateCarName(carName);
        }

        CarNameValidator.validateDuplicateCarName(convertedCarNames);
        CarNameValidator.validateMaxCountCarName(convertedCarNames);

        return convertedCarNames;
    }

    private List<String> convertToList(String carNames) {
        return Arrays.stream(carNames.split(CarNameValidator.MULTIPLE_CAR_NAME_DELIMITER, -1))
            .toList();
    }
}
