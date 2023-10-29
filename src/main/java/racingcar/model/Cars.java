package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.InputValidator;

public class Cars {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
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
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        cars.forEach(car -> {
            car.decideToMove(randomNumber);
        });
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
