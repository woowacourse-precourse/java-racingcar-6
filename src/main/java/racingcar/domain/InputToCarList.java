package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputToCarList {
    private static final String NO_PLAYERS_PARTICIPATE = "모집 된 선수가 없습니다.";
    private static final String USER_DEFAULT_DELIMITER = ",";

    private static class SingletonHelper {
        private static final InputToCarList INSTANCE = new InputToCarList();
    }

    public static InputToCarList getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private InputToCarList() {
    }

    public List<Car> askCarName(final String input) {
        List<Car> cars = Arrays.stream(input.split(USER_DEFAULT_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());

        Set<String> carNamesSet = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (cars.size() > carNamesSet.size()) {
            throw new IllegalArgumentException("중복되는 이름이 있습니다.");
        }

        if (input.endsWith(USER_DEFAULT_DELIMITER)) {
            throw new IllegalArgumentException("문장의 마지막 문자는 컴마(',') 를 허용하지 않습니다.");
        }

        if (cars.isEmpty()) {
            throw new IllegalArgumentException(NO_PLAYERS_PARTICIPATE);
        }

        return cars;
    }
}
