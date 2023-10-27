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
        OutputView.printCarNamesMessage();
        List<String> carStrings = InputView.getCarStrings();
        OutputView.printMoveCountMessage();
        int moveCount = InputView.getMoveCount();
        List<Car> carList = CarListGenerator.getCarList(carStrings);
        Cars cars = new Cars(carList);
        OutputView.printResultMessage();
        for (int count = 0; count < moveCount; count++) {
            cars.move();
            OutputView.printCarsLocation(cars);
        }
        OutputView.printWinner(cars.getWinnerList());
    }
}
