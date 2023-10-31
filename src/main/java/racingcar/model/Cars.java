package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.CarNamesValidator;

public class Cars {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private final List<Car> cars;

    public Cars(String names) {
        CarNamesValidator.validate(names);
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
        cars.forEach(car -> {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            car.decideToMove(randomNumber);
        });
    }

    public String generateRoundResultString() {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car.getResultFormat());
            sb.append("\n");
        });
        return sb.toString();
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
