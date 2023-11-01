package racingcar.Validator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarNameValidator {

    public static List<String> validateCarNames(String carNamesInput) {
        if (isNotSplitByComma(carNamesInput)) {
            throw new IllegalArgumentException("자동차는 쉼표(,)로 구분해주세요.");
        }

        List<String> carNames = splitByComma(carNamesInput);
        
        return carNames;
    }

    private static List<String> splitByComma(String input) {
        return Pattern.compile(",")
                .splitAsStream(input)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static boolean isNotSplitByComma(String carName) {
        return !carName.contains(",");
    }
}
