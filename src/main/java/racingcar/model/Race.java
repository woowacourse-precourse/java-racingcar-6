package racingcar.model;

import static racingcar.constant.GameConfig.MINIMUM_NUMBER_FOR_FORWARD;
import static racingcar.constant.GameConfig.RANDOM_MAXIMUM_RANGE;
import static racingcar.constant.GameConfig.RANDOM_MINIMUM_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Race {

    private List<Car> cars;

    public Race(List<String> carNames) {
        setCarsFromNames(carNames);
    }

    public void moveAllCarsForward() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(RANDOM_MINIMUM_RANGE, RANDOM_MAXIMUM_RANGE);

            if (randomValue >= MINIMUM_NUMBER_FOR_FORWARD) {
                car.forward();
            }
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
        List<Car> sortedCars = sortCarsByPosition();
        int maxPosition = sortedCars.get(0).getPosition();

        return sortedCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private List<Car> sortCarsByPosition() {
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
