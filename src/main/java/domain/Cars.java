package domain;

import static constant.ConstantNumber.DEFAULT_MAX_MOVE_COUNT;
import static constant.ConstantString.DELIMITER;

import controller.RaceController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import validator.NameValidator;

public class Cars {
    public final List<Car> carsList = new ArrayList<>();

    public Cars(String carNames) {
        List<String> carNameList = splitCarNames(carNames);
        NameValidator.isNameDuplicate(carNameList);
        carNameList.forEach(carName -> carsList.add(new Car(carName)));
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int findMaxMoveCount() {
        int maxMoveCount = DEFAULT_MAX_MOVE_COUNT.getValue();

        for (Car car : carsList) {
            int moveCount = car.getMoveCount();
            if (moveCount > maxMoveCount) {
                maxMoveCount = moveCount;
            }
        }
        return maxMoveCount;
    }

    public void MoveCars() {
        for (Car car : carsList) {
            int randomNumber = RaceController.getRandomNumber();
            car.moveOrStop(randomNumber);
        }
    }

    public List<Car> getCarsList() {
        return carsList;
    }
}
