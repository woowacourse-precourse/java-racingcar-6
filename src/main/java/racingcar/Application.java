package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarListGenerator;
import racingcar.domain.Cars;
import racingcar.domain.InputView;
import racingcar.domain.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = getCarsFromUser();
        int moveCount = getMoveCountFromUser();
        printResults(cars, moveCount);
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

    public static void printResults(Cars cars, int moveCount) {
        OutputView.printResultMessage();
        for (int count = 0; count < moveCount; count++) {
            cars.move();
            OutputView.printCarsLocation(cars);
        }
        OutputView.printWinner(cars.getWinnerList());
    }
}
