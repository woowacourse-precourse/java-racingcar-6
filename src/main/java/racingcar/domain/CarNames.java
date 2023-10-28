package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarNames {
    private final List<CarName> names;
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 이름을 입력할 수 없습니다.";
    private static final String NAMES_COUNT_ERROR_MESSAGE = "이름을 최소 2개이상 입력해주세요.";
    private static final String NAME_DELIMITER = ",";
    private static final int MIN_NAMES_COUNT = 2;

    private CarNames(List<CarName> carNames){
        validateDuplicate(carNames);
        validateEmpty(carNames);
        this.names = carNames;
    }

    public static CarNames from(String input){
        return new CarNames(generateCarNames(input));
    }

    public static List<CarName> generateCarNames(String input){
        String[] names = splitByDelimiter(input);
        return createCarNames(names);
    }

    public static String[] splitByDelimiter(String input) {
        return input.split(NAME_DELIMITER);
    }

    public static List<CarName> createCarNames(String[] names){
        return Arrays.stream(names)
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<CarName> carNames) {
        Set<CarName> seenNames = new HashSet<>();

        for (CarName name : carNames) {
            if (seenNames.contains(name)) {
                throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
            }
            seenNames.add(name);
        }
    }


    private void validateEmpty(List<CarName> carNames){
        if(names.size() < MIN_NAMES_COUNT){
            throw new IllegalArgumentException(NAMES_COUNT_ERROR_MESSAGE);
        }
    }
}
