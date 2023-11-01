package racingcar.model;

import static racingcar.constant.Number.MAX_RANDOM_NUMBER;
import static racingcar.constant.Number.MIN_RANDOM_NUMBER;
import static racingcar.constant.Number.MOVE_CAR_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.CarNameController;
import racingcar.controller.GameResultController;
import racingcar.validation.CarNameValidation;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String names) {
        CarNameValidation.validation(names);
        generateCars(names);
    }

    private void generateCars(String names) {
        List<String> nameList = CarNameController.parseNamesToList(names);
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public void decideToMove() {
        cars.forEach(car -> {
            if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MOVE_CAR_NUMBER) {
                car.movePosition();
            }
        });
    }

    public String generateRoundResultString() {
        return GameResultController.roundFormat(cars);
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            if (car.isGreaterPositionThan(maxPosition)) {
                maxPosition = car.position();
            }
        }
        return maxPosition;
    }

    public List<Car> getWinners() {
        Position maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }
}
