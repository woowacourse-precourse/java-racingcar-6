package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.message.ErrorMessage;

public class Cars {

    private static final int MIN_REQUIRED_CAR_NUMBER = 2;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final List<Car> cars;

    public Cars(String names) {
        List<Name> nameList = Name.createNameList(names);
        validateDuplicateCarName(nameList);
        validateMoreThanOneCars(nameList);

        cars = nameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void tryRun() {
        for (Car car : cars) {
            int isGoodToRun = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            car.run(isGoodToRun);
        }
    }

    private void validateDuplicateCarName(List<Name> nameList) {
        Set<Name> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_CONDITION);
        }
    }

    private void validateMoreThanOneCars(List<Name> nameList) {
        if (nameList.size() < MIN_REQUIRED_CAR_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MORE_THAN_ONE_CAR);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}