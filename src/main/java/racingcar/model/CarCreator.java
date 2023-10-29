package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarCreator {
    public List<String> createCarList(String inputItem) {
        List<String> carNames = Arrays.asList(inputItem.split(","));
        validateAll(carNames);
        return carNames;
    }

    private void validateAll(List<String> carNames) {
        validateNameLength(carNames);
        validateSize(carNames);
        validateDuplicateCarName(carNames);
        validateBlank(carNames);
    }

    private void validateNameLength(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() > NumberEnum.MAX_LENGTH.getNumber()) {
                throw new IllegalArgumentException(MessageEnum.MAX_LENGTH_EXCEEDED.getMessage());
            }
        }
    }

    private void validateSize(List<String> carNames) {
        if (carNames.size() < NumberEnum.MIN_SIZE.getNumber()) {
            throw new IllegalArgumentException(MessageEnum.MIN_SIZE_VALIDATE_MESSAGE.getMessage());
        }
    }

    private void validateDuplicateCarName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException(MessageEnum.DUPLICATION_VALIDATE_MESSAGE.getMessage());
        }
    }

    private void validateBlank(List<String> carNames) {
        if (carNames.stream().anyMatch(name -> name.trim().isEmpty())) {
            throw new IllegalArgumentException(MessageEnum.BLANK_INPUT_MESSAGE.getMessage());
        }
    }

}
