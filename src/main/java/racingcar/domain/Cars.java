package racingcar.domain;

import static racingcar.common.response.ErrorCode.CAR_NAME_DUPLICATION;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.common.exception.CustomErrorException;

public class Cars {

    private static final String SEPARATOR = ",";
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final List<Car> cars;

    public Cars(String input) {
        String[] names = input.split(SEPARATOR);
        validateNames(names);
        this.cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void racing() {
        for (Car car : cars) {
            int number = createRandomNumber();
            car.move(number);
        }
    }

    private static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
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
