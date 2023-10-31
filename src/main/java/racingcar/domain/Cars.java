package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.Utils.ErrorMessage;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateUserInput(cars);
        this.cars = cars;
    }

    public Cars(String[] carNames) {
        this(Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public static void validateUserInput(List<Car> userInput) {
        for (Car car : userInput) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_ONLY_FIVE_BELOW.getMessage());
            }
        }
        Set<Car> carNames = new HashSet<>(userInput);
        if (carNames.size() != userInput.size()) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_DUPLICATION.getMessage());
        }
    }

    public void playSingleTurn() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Map<String, Integer> carsInformation() {
        Map<String, Integer> currentPosition = new HashMap<>();
        for (Car car : cars) {
            currentPosition.put(car.getName(), car.getPosition());
        }
        return currentPosition;
    }

    public int getCurrentPosition() {
        int currentMaxPosition = 0;
        for (Car car : cars) {
            currentMaxPosition = Math.max(currentMaxPosition, car.getPosition());
        }
        return currentMaxPosition;
    }

    public List<Car> findWinner(int currentMaxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == currentMaxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
