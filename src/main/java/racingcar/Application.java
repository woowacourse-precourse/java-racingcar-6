package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        List<String> carNames = inputView.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName: carNames) {
            cars.add(Car.create(carName));
        }

        int round = inputView.getNumberOfRound();
        System.out.println("\n실행 결과");
        for (int i = 0; i < round; ++i) {
            for (Car car: cars) {
                car.tryMove();
            }
            outputView.printCars(cars);
        }
        Stack<Car> winners = Referee.pickWinners(cars);
        outputView.printWinners(winners);
    }
}
