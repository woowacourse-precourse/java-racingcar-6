package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class NameInput {

    static public void inputNames(List<Car> cars) {
        List<String> carNames = List.of(readLine().split(","));
        NameValidation nameValidation = new NameValidation();
        carNames.forEach(nameValidation::isValid);

        List<Car> newCars = carNames.stream()
                .map(Car::new)
                .toList();

        cars.addAll(newCars);
    }
}
