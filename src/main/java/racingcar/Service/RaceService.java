package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;

import java.util.*;

public class RaceService {
    InputValidation inputValidation = new InputValidation();

    public int RandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String winnerResult(List<Car> cars) {
        cars.sort(((o1, o2) -> o2.getLocation() - o1.getLocation()));
        int maxNum = cars.get(0).getLocation();
        List<String> members = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxNum) {
                members.add(car.getName());
            }
        }
        return String.join(", ", members);
    }

    public List<String> carNameStringToList(String carName) {
        return inputValidation.checkCarNamesValidation(carName);
    }


}
