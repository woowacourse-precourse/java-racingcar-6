package racingcar.model;

import static racingcar.constant.GameConfig.MINIMUM_NUMBER_FOR_FORWARD;
import static racingcar.constant.GameConfig.RANDOM_MAXIMUM_RANGE;
import static racingcar.constant.GameConfig.RANDOM_MINIMUM_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Race {

    private List<Car> cars;

    public Race(List<String> carNames) {
        setCarsFromNames(carNames);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void forwardAllCarsWithRandom() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(
                    RANDOM_MINIMUM_RANGE.getValue(),
                    RANDOM_MAXIMUM_RANGE.getValue());

            forwardCar(car, randomValue);
        }
    }

    public void forwardCar(Car car, int value) {
        if (value >= MINIMUM_NUMBER_FOR_FORWARD.getValue()) {
            car.forward();
        }
    }

    public void displayAllCarsPosition() {
        for (Car car : cars) {
            OutputView.printCarPosition(car.getName(), car.getPosition());
        }

        OutputView.printNewLine();
    }

    public void displayWinnerNames() {
        List<Car> winners = findWinners();

        OutputView.printWinner(winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList()));
    }

    public List<Car> findWinners() {
        List<Car> sortedCars = sortCarsByPositionDescending();
        int maxPosition = sortedCars.get(0).getPosition();

        return sortedCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public int getCarSize() {
        return cars.size();
    }

    private List<Car> sortCarsByPositionDescending() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getPosition).reversed())
                .collect(Collectors.toList());
    }

    private void setCarsFromNames(List<String> names) {
        cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
