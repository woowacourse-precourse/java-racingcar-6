package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class CarRacingGameService {
    public Car getCar(String carNameInput) {
        List<String> carNameInputList = List.of(carNameInput.split(","));

        validateCarNameInput(carNameInputList);

        return new Car(carNameInputList);
    }

    private void validateCarNameInput(List<String> carNameInputList) {
        checkDuplicateName(carNameInputList);
        checkBlank(carNameInputList);
        checkNameLength(carNameInputList);
    }

    private void checkDuplicateName(List<String> carNameInputList) {
        Set<String> inputCarNameSet = new HashSet<>(carNameInputList);

        if (inputCarNameSet.size() != carNameInputList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void checkBlank(List<String> carNameInputList) {
        for (String inputCarName : carNameInputList) {
            if (inputCarName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름은 공백을 포함할 수 없습니다.");
            }
        }
    }

    private void checkNameLength(List<String> carNameInputList) {
        for (String inputCarName : carNameInputList) {
            if (inputCarName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 넘길 수 없습니다.");
            }
        }
    }
}
