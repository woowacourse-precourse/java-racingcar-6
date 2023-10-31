package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarList(String userInput) {
        List<Car> carList = putCarIntoList(extractNamesList(userInput));

        return new Cars(carList);
    }

    private static List<Car> putCarIntoList(List<String> names) {
        List<Car> cars = names.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(cars);
    }

    private static List<String> extractNamesList(String userInput) {
        String[] names = userInput.split(",");

        return List.of(names);
    }

    public List<String> findWinnerCars() {
        int maximumDistance = findMaximumDistance();

        return cars.stream()
                .filter(car -> car.isSameDistance(maximumDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaximumDistance() {
        int maximumDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return maximumDistance;
    }

    public void printCarsGameResult(Integer runningCount) {
        for (int i = 0; i < runningCount; i++) {
            cars.forEach(Car::moveByGeneratedNumber);
            cars.forEach(car ->
                    OutputView.printPerMoveResult(car.toString()));
            System.out.println();
        }
    }
}
