package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.message.ErrorMessage;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        List<Name> nameList = Name.createNameList(names);
        validateDuplicateCarName(nameList);

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

    public List<Car> getCars() {
        return cars;
    }
}