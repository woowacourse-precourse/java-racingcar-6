package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.constant.ErrorMessage;

public class InputView {
    private final String DELIMITER = ",";
    private final String NUMERIC_PATTERN = "^[0-9]*$";

    public List<String> getCarNames() {
        try {
            String carNamesRawData = Console.readLine();

            validateNull(carNamesRawData, ErrorMessage.CAR_NAME_INPUT_EXCEPTION.getMessage());
            validateBlank(carNamesRawData, ErrorMessage.CAR_NAME_INPUT_EXCEPTION.getMessage());

            String[] splitCarNamesByComma = carNamesRawData.split(DELIMITER);
            return carNamesArrToList(splitCarNamesByComma);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INPUT_EXCEPTION.getMessage());
        }
    }

    public int getMovementTime() {
        try {
            String movementTimeStr = Console.readLine();

            validateNull(movementTimeStr, ErrorMessage.MOVEMENT_TIME_INPUT_EXCEPTION.getMessage());
            validateBlank(movementTimeStr, ErrorMessage.MOVEMENT_TIME_INPUT_EXCEPTION.getMessage());
            validateNumericValue(movementTimeStr);

            return Integer.parseInt(movementTimeStr);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.MOVEMENT_TIME_INPUT_EXCEPTION.getMessage());
        }
    }

    private void validateNull(String data, String errorMessage) {
        if (data == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateBlank(String data, String errorMessage) {
        if (data.isBlank()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private List<String> carNamesArrToList(String[] splitCarNamesByComma) {
        List<String> carNames = new ArrayList<>();
        Set<String> setCarNames = new HashSet<>();
        for (int idx = 0; idx < splitCarNamesByComma.length; idx++) {
            String carName = splitCarNamesByComma[idx].trim();
            validateCarNameLength(carName);
            validateDuplicateName(carName, setCarNames);
            carNames.add(carName);
        }

        return carNames;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5 || carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    private void validateDuplicateName(String carName, Set<String> setCarNames) {
        if (!setCarNames.add(carName)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_EXCEPTION.getMessage());
        }
    }

    private void validateNumericValue(String movementTimeStr) {
        if (!Pattern.matches(NUMERIC_PATTERN, movementTimeStr)) {
            throw new IllegalArgumentException(ErrorMessage.MOVEMENT_TIME_TYPE_EXCEPTION.getMessage());
        }
    }
}
