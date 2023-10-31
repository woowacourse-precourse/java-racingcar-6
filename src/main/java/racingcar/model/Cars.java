package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.message.ErrorMessage;

public class Cars {

    private static final int MIN_REQUIRED_CAR_NUMBER = 2;

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
            int isGoodToRun = Randoms.pickNumberInRange(0, 9);
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
        return cars;
    }
}