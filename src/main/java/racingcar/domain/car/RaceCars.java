package racingcar.domain.car;

import racingcar.util.Randoms;
import racingcar.view.ExecutionView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceCars {
    //자료 구조
    private final List<Car> cars;

    public RaceCars(List<Car> cars) {
        this.cars = cars;
    }

    public int size(){
        return cars.size();
    }

    private Stream<Car> stream(){
        return cars.stream();
    }

    //계산 로직
    public String getWinningCarNames(){
        int max = maxCarMovementCount();

        return cars.stream()
                .filter(car -> car.getMoveCount() == max)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int maxCarMovementCount(){
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max().orElse(0);
    }

    public void executeRace(){
        stream().forEach(car -> car.controlMovement(Randoms.getNumber()));
    }

    //출력 로직
    public void printGameProgressMessages(){
        stream().forEach(ExecutionView::printExecutionMessage);
    }

    public void printWinningCarNames(){
        ExecutionView.printWinningCarNames(getWinningCarNames());
    }

}
