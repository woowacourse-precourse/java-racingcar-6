package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private static final String RESULT_FORMAT = "%s : %s\n";
    private static final String LOCATION_SIGN = "-";
    private static final String WINNER_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_NAMES_DELIMITER = ",";
    private static final MovingRule movingRule = new MovingRule();

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final List<Car> cars = new ArrayList<>();

    public void addCar(String carName) {
        Car car = new Car(carName);
        cars.add(car);
    }

    public void moveCars() {
        for (Car car : cars) {
            if (isMovable(car)) {
                car.move();
            }
        }
    }

    private boolean isMovable(Car car) {
        int randomNum = numberGenerator.generate();
        return movingRule.isMovable(randomNum);
    }

    public String makeResult() {
        StringBuilder results = new StringBuilder();

        for (Car car : cars) {
            String name = car.getName();
            String locationSigns = makeLocationSigns(car.getLocation());
            String result = String.format(RESULT_FORMAT, name, locationSigns);

            results.append(result);
        }

        return results.toString();
    }

    private String makeLocationSigns(int location) {
        return LOCATION_SIGN.repeat(location);
    }

    public String makeWinnerResult() {
        int maxLocation = findMaxLocation(cars);
        List<String> winnerNames = findWinnerNames(cars, maxLocation);

        return String.format(WINNER_FORMAT, String.join(WINNER_NAMES_DELIMITER, winnerNames));
    }

    private int findMaxLocation(List<Car> cars) {
        List<Integer> locations = cars.stream()
                .map(Car::getLocation)
                .toList();

        return Collections.max(locations);
    }

    private List<String> findWinnerNames(List<Car> cars, int maxLocation) {
        return cars.stream()
                .filter(car -> car.isWinner(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
