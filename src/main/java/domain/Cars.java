package domain;

import static constant.ConstantString.DELIMITER;

import controller.RaceController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import validator.NameValidator;

public class Cars {
    private final List<Car> carsList = new ArrayList<>();

    public Cars(String carNames) {
        List<String> carNameList = splitCarNames(carNames);
        NameValidator.isCarCountLessThanTwo(carNameList);
        NameValidator.isNameDuplicate(carNameList);
        carNameList.forEach(carName -> carsList.add(new Car(carName)));
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public void MoveCars() {
        for (Car car : carsList) {
            int randomNumber = RaceController.getRandomNumber();
            car.moveOrStop(randomNumber);
        }
    }

    public List<String> getWinners() {
        Winners winners = new Winners(carsList);
        return winners.getWinners();
    }

    public List<Car> getCarsList() {
        return carsList;
    }
}
