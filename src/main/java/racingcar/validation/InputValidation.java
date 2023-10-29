package racingcar.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.view.Inputview;

public class InputValidation {

    private static final String COMMA = ",";
    private static final int MAX_STRING = 5;
    private static final int MIN_STRING = 1;
    private static final String CAR_NAME_LENGTH_VALIDATION_EXCEPTION = "자동차 이름은 1 ~ 5 자리로 입력해야 합니다.";
    private static final String CAR_NAME_SEPARATE_COMMA_EXCEPTION = "자동차 이름을 쉼표로 구분하여 2개 이상 입력해야 합니다.";
    private static final String CAR_SAME_NAME_EXCEPTION = "자동차 이름은 자동차마다 다르게 입력해야 합니다.";
    private static final String RACE_GAME_TRY_NUMBER = "게임을 시도할 횟수는 숫자민 입력 가능합니다.";


    public static List<String> validationName(String carName) {
        if (carName == null || carName.isBlank() || carName.length() < MIN_STRING || carName.length() > MAX_STRING) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_VALIDATION_EXCEPTION);
        }
        return Arrays.asList(carName);
    }


    public static List<String> validationNameSeparate(List<String> carNames) {
        List<String> validatedNames = new ArrayList<>();

        for (String name : carNames) {
            validatedNames.addAll(validationName(name));
        }

        carSameNameValidation(validatedNames);

        return validatedNames;
    }


    public static List<String> validateAndSplit(String name) {
        List<String> namesList = Arrays.asList(name.split(COMMA));
        if (namesList.size() < 2) {
            throw new IllegalArgumentException(CAR_NAME_SEPARATE_COMMA_EXCEPTION);
        }
        return namesList;
    }

    public static void carSameNameValidation(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException(CAR_SAME_NAME_EXCEPTION);
        }
        Inputview.tryGameNumber();
    }

    // 사용자가 숫자가 아닌 다른 값을 입력했을 경우 예외 처리
    public static int carNumericValidation(String input) {
        try {
            return Integer.parseInt(String.valueOf(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RACE_GAME_TRY_NUMBER);
        }
    }
}

