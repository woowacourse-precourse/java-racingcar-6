package racingcar.validator;

import java.util.Arrays;
import java.util.List;


public class CarNamesValidator {
    public static final int CAR_NAME_STANDARD_LENGTH = 5;
    private final String carNames;

    public CarNamesValidator(String carNames) {
        this.carNames = carNames;
        String[] splitedNames = carNames.split(",");
        Arrays.stream(splitedNames)
                .forEach(carName -> isOverStandardLength(carName));
        hasDuplicatedNames(Arrays.asList(splitedNames));
    }

    private void isOverStandardLength(String s) {
        if (s.length() > CAR_NAME_STANDARD_LENGTH) {
            throw new IllegalArgumentException("5글자가 넘어갔습니다");
        }
    }

    private void hasDuplicatedNames(List<String> splitedNames) {
        if (splitedNames.size() != splitedNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다");
        }
    }


}
