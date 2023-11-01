package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME = 5;
    private static final int MIN_RACING_NUMBER = 1;
    private static final String ERROR_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다";
    private static final String ERROR_NUMBER_ONLY = "시도 횟수에는 1 이상의 정수만 입력 가능합니다";
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

    public int inputRacingNumber() {
        String userInput = Console.readLine();
        int inputNumber = validateNumber(userInput);

        validateNumberLength(inputNumber);

        return inputNumber;
    }

    private int validateNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_ONLY);
        }
    }

    private void validateCarNames(String[] carNameArray) {
        for (String carName : carNameArray) {
            if (carName.length() > MAX_CAR_NAME) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }

    private void validateNumberLength(int inputNumber) {
        if (!(inputNumber >= MIN_RACING_NUMBER)) {
            throw new IllegalArgumentException(ERROR_NUMBER_ONLY);
        }
    }
}
