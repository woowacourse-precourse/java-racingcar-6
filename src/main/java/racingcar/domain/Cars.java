package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import racingcar.util.Generator;
import racingcar.view.OutputView;

public class Cars {
    private static final String RESULT_DELIMITER = "\n";
    private static final String WINNER_DELIMITER = ", ";
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCarsFromNames(String[] names) {
        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void tryMovements() {
        cars.forEach(car -> {
            int number = Generator.createRandomNumber();
            car.judgeNumberToGo(number);
        });

        OutputView.printUpdatedResult(updateResult());
    }

    public String updateResult() {
        StringJoiner result = new StringJoiner(RESULT_DELIMITER);
        cars.forEach(car -> result.add(car.toString()));
        return result.toString();
    }

    public String findWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();

        String winners = cars.stream()
                .filter(car -> car.isEqualDistance(maxDistance))
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));

        return winners;
    }
}