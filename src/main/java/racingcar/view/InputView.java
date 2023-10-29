package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constant.ErrorMessage;

public class InputView {
    private final String DELIMITER = ",";

    public List<String> getCarNames() {
        try {
            String carNamesRawData = Console.readLine();

            validateNull(carNamesRawData);
            validateBlank(carNamesRawData);

            String[] splitCarNamesByComma = carNamesRawData.split(DELIMITER);
            return carNamesArrToList(splitCarNamesByComma);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INPUT_EXCEPTION.getMessage());
        }
    }

    private void validateNull(String data) {
        if (data == null) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INPUT_EXCEPTION.getMessage());
        }
    }

    private void validateBlank(String data) {
        if (data.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INPUT_EXCEPTION.getMessage());
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
}
