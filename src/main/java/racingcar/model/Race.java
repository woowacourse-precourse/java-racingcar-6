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

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void forwardAllCarsWithRandom() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(
                    RANDOM_MINIMUM_RANGE.getValue(),
                    RANDOM_MAXIMUM_RANGE.getValue());

            if (randomValue >= MINIMUM_NUMBER_FOR_FORWARD.getValue()) {
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
        List<Car> sortedCars = sortCarsByPositionDescending();
        int maxPosition = sortedCars.get(0).getPosition();

        return sortedCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private List<Car> sortCarsByPositionDescending() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getPosition).reversed())
                .collect(Collectors.toList());
    }
}
