package racingcar;

import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.CarListGenerator;
import racingcar.domain.Cars;
import racingcar.domain.InputView;
import racingcar.domain.OutputView;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = getCarsFromUser();
        int moveCount = getMoveCountFromUser();
        printResultsWithMove(cars, moveCount);
        Referee referee = new Referee(cars.getMoveCountMap());
        printWinners(referee);
    }

    public static Cars getCarsFromUser() {
        OutputView.printCarNamesMessage();
        List<String> carStrings = InputView.getCarStrings();
        List<Car> carList = CarListGenerator.getCarList(carStrings);
        return new Cars(carList);
    }

    public static int getMoveCountFromUser() {
        OutputView.printMoveCountMessage();
        return InputView.getMoveCount();
    }

    public static void printResultsWithMove(Cars cars, int moveCount) {
        OutputView.printResultMessage();
        for (int count = 0; count < moveCount; count++) {
            cars.move();
            Map<String, Integer> moveCountMap = cars.getMoveCountMap();
            OutputView.printCarsLocation(moveCountMap);
        }
    }

    public static void printWinners(Referee referee) {
        OutputView.printWinner(referee.getWinnerList());
    }
}
