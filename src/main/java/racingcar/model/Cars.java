package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        List<Name> nameList = Name.createNameList(names);
        Name.validateDuplicateName(nameList);

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

    public List<Car> getCars() {
        return cars;
    }
}