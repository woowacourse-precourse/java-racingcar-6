package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.util.BlankValidator;

public class CarNameManager {
    private static final String PLEASE_INPUT_CAR_NAME_LENGTH_5 = "의 이름 5자를 초과했습니다";
    private static final String PLEASE_INPUT_NOT_DUPLICATE_CAR_NAMES = "중복된 자동차 이름이 있습니다.";
    private static final String PLEASE_INPUT_CORRECT_CAR_NAMES = "잘못된 자동차 이름 입력 형식입니다.";
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private final BlankValidator blankValidator;

    public CarNameManager(BlankValidator blankValidator) {
        this.blankValidator = blankValidator;
    }

    public List<String> processCarNames(String carNames) {
        blankValidator.isEmpty(carNames);
        return processInput(carNames);
    }

    public void validateCarNames(List<String> carNameList) {
        validateNameLength(carNameList);
        validateUniqueNames(carNameList);
    }

    private List<String> processInput(String carNames) {
        validateCommas(carNames);
        List<String> names = splitByComma(carNames);
        return trimList(names);
    }

    private void validateCommas(String carNames) {
        if (carNames.startsWith(",") || carNames.endsWith(",") || carNames.contains(",,")) {
            throw new IllegalArgumentException(PLEASE_INPUT_CORRECT_CAR_NAMES);
        }
    }

    private List<String> splitByComma(String carNames) {
        return Arrays.asList(carNames.split(","));
    }

    private List<String> trimList(List<String> carNameList) {
        List<String> trimmedList = new ArrayList<>();
        for (String name : carNameList) {
            trimmedList.add(name.trim());
        }
        return trimmedList;
    }

    private void validateNameLength(List<String> carNameList) {
        carNameList.stream()
                .filter(name -> name.length() > CAR_NAME_LENGTH_LIMIT)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(name + PLEASE_INPUT_CAR_NAME_LENGTH_5);
                });
    }

    private void validateUniqueNames(List<String> carNameList) {
        HashSet<String> uniqueNames = new HashSet<>(carNameList);
        if (uniqueNames.size() < carNameList.size()) {
            throw new IllegalArgumentException(PLEASE_INPUT_NOT_DUPLICATE_CAR_NAMES);
        }
    }
}

