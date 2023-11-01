package racingcar.Validator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarNameValidator {
    private static final int maxCarCount = 9;
    private static final int maxCarName = 5;
    private static final String commaSeparator = ",";

    public static List<String> validateCarNames(String carNamesInput) {
        if (isNotSplitByComma(carNamesInput)) {
            throw new IllegalArgumentException("자동차는 쉼표(,)로 구분해주세요.");
        }

        List<String> carNames = splitByComma(carNamesInput);

        for (String carName : carNames) {
            if (isInvalidCarName(carName)) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
            }

            if (carNames.isEmpty() || carNames.size() > maxCarCount) {
                throw new IllegalArgumentException("자동차 개수는 1개 이상 9개 이하여야 합니다.");
            }
        }
        return carNames;
    }

    private static List<String> splitByComma(String input) {
        return Pattern.compile(commaSeparator)
                .splitAsStream(input)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static boolean isInvalidCarName(String carName) {
        return carName.isEmpty() || carName.length() > maxCarName;
    }

    private static boolean isNotSplitByComma(String carName) {
        return !carName.contains(commaSeparator);
    }

}
