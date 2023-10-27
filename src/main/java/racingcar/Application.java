package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printCarNamesMessage();
        List<String> carStrings = InputView.getCarStrings();
        OutputView.printMoveCountMessage();
        int moveCount = InputView.getMoveCount();
        List<Car> carList = CarListGenerator.getCarList(carStrings);
        Cars cars = new Cars(carList);
        OutputView.printResult(cars, moveCount);
        OutputView.printWinner(cars.getWinnerList());
    }
}
