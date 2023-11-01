package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars(InputView.getCarsName().split(","));
        int loopCount = Integer.parseInt(InputView.getLoopCount());
        OutputView.showResultMessage();
        for (int i = 0; i < loopCount; i++) {
            cars.moveAllCars();
            for (Car car : cars.getCars()) {
                OutputView.showCarDistanceResults(car.getName(),
                        OutputView.createDistanceString(car.getDistance()));
            }
            System.out.println();
        }
        OutputView.winnerResult(cars.compareCarDistances());
    }
}
