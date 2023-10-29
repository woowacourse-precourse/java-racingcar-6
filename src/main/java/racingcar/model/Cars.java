package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.InputValidator;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        InputValidator.validateCarNames(names);
        cars = generateCars(names);
    }

    private List<Car> generateCars(String names) {
        List<Car> carList = new ArrayList<>();
        String[] carNamesArray = names.replace(" ", "").split(",");
        for (String carName : carNamesArray) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public void decideToMove() {
        cars.forEach(Car::decideToMove);
    }

    public String generateRoundResultString() {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car.getDisplayFormat());
            sb.append("\n");
        });
        return sb.toString();
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            if (car.position().isGreaterThan(maxPosition)) {
                maxPosition = car.position();
            }
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        Position maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> maxPosition.equals(car.position()))
                .map(car -> car.name().getDisplayFormat())
                .collect(Collectors.toList());
    }

}
