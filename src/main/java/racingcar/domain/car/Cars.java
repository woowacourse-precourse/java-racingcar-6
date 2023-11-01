package racingcar.domain.car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void performRound() {
        for (Car car : cars) {
            car.carMove();
        }
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<String> sortFinalWinner() {
        List<Car> sortedCars = getSortedCars(cars);
        List<Car> farthestCars = getFarthestCars(sortedCars);
        return getWinnerCarNames(farthestCars);
    }

    private List<Car> getSortedCars(List<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getCarLocation).reversed()).toList();
    }

    private List<Car> getFarthestCars(List<Car> sortedCars) {
        int farthestLocation = sortedCars.get(0).getCarLocation();
        return sortedCars.stream()
                .filter(car -> car.getCarLocation() == farthestLocation).toList();
    }

    private List<String> getWinnerCarNames(List<Car> farthestCars) {
        return farthestCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
