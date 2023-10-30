package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;

import java.util.*;
import java.util.stream.Collectors;

public class RaceService {
    InputValidation inputValidation = new InputValidation();

    public int RandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String winnerResult(List<Car> cars) {
        cars.sort(((o1, o2) -> o2.getLocation() - o1.getLocation()));
        int maxNum = cars.get(0).getLocation();
        List<String> members = cars.stream()
                .filter(car -> car.getLocation() == maxNum)
                .map(Car::getName)
                .collect(Collectors.toList());
        return String.join(", ", members);
    }

    public List<String> carNameStringToList(String carName) {
        return inputValidation.checkCarNamesValidation(carName);
    }


}
