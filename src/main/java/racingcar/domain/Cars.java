package racingcar.domain;

import static racingcar.common.response.ErrorCode.CAR_NAME_DUPLICATION;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.common.exception.CustomErrorException;

public class Cars {

    private static final String SEPARATOR = ",";

    private final List<Car> cars;

    public Cars(String input) {
        String[] names = input.split(SEPARATOR);
        validateNames(names);
        this.cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateNames(String[] names) {
        if (isDuplicatedNames(names)) {
            throw new CustomErrorException(CAR_NAME_DUPLICATION);
        }
    }

    private boolean isDuplicatedNames(String[] names) {
        Set<String> set = new HashSet<>(Arrays.asList(names));
        return names.length != set.size();
    }
}
