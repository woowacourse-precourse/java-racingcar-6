package racingcar.Controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void run() {
        String names = inputView.readName();
        Car car = new Car(names);
        int count = inputView.readCount();

        for (int i = 0; i < count; i++) {
            car.start();
            outputView.printResult(car.getResult());
        }
        outputView.printWinner(car.getWinner());
    }
}
