package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static  final String NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME = 5;
    private static final String ERROR_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다";
    public InputView() {
    }

    public List<String> inputCarNames() {
        String userInput = Console.readLine();

        String[] carNameArray = Arrays.stream(userInput.split(NAME_DELIMITER))
                .map(String::trim)
                .filter(carName -> !carName.isEmpty())
                .toArray(String[]::new);

        validateCarNames(carNameArray);
        return Arrays.asList(carNameArray);
    }

    private void validateCarNames(String[] carNameArray) {
        for (String carName : carNameArray) {
            if (carName.length() > MAX_CAR_NAME) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }
}
