package racingcar.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import racingcar.controller.RaceController;
import racingcar.view.OutputView;

public class Cars {
    private static List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void raceCars() {
        cars.stream()
                .filter(RaceController::isMoving)
                .forEach(car -> car.moveCount++);
        printRace();
    }

    private void printRace() {
        cars.forEach(OutputView::printRace);
        OutputView.printNewLine();
    }

//    public void findWinner() {
//        int maxMoveCount = getMaxMoveCount();
//        List<String> winners = cars.stream()
//                .filter(car -> car.moveCount == maxMoveCount)
//                .map(car -> car.name)
//                .toList();
//        OutputView.printWinners(winners);
//    }
//    private int getMaxMoveCount() {
//        Optional<Integer> maxMoveCount = cars.stream()
//                .map(car -> car.moveCount)
//                .max(Integer::compare);
//        if (maxMoveCount.isPresent()) {
//            return maxMoveCount.get();
//        }
//        throw new IllegalArgumentException();
//    }
}
