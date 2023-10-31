package racingcar.model;

import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    public final List<Car> cars;

    public CarManager(){
        cars = new ArrayList<>();
    }

    public void setCars(String alignedCarNames) {
        InputValidator.validateConsecutiveCommas(alignedCarNames);
        String[] carNames = alignedCarNames.split(",");
        InputValidator.validateName(carNames);
        InputValidator.validateNameLength(carNames);
        InputValidator.validateDuplicateName(carNames);

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public List<String> getWinnerNames() {
        List<Integer> positions = getAllPositions();
        List<String> winners = new ArrayList<>();
        int topPosition = getTopPosition(positions);

        for (Car car : cars) {
            if (car.getPosition() == topPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public Integer getTopPosition(List<Integer> positions) {
        Integer topPosition = positions.stream()
                .max(Integer::compareTo).get();
        return topPosition;
    }

    public List<Integer> getAllPositions(){
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }
}
