package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    private final static int FIRST_CAR = 0;
    private Judgment judgment = new Judgment();
    private Random random = new Random();
    private Referee referee = new Referee();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private List<Car> cars = new ArrayList<>();

    public void start() {
        User user = new User();
        cars = user.nameForCar(inputView.inputCars());
        int count = inputView.inputCount();
        repeat(count);
        outputView.printWinner(referee.announceWinner(referee.decideWinner(cars)));
    }

    private void repeat(int count) {
        System.out.println("실행 결과");
        for (int num = 0; num < count; num++) {
            startForEach();
            System.out.println();
        }
    }

    private void startForEach() {
        for (int car = FIRST_CAR; car < cars.size(); car++) {
            if (judgment.isNumberFourOrMore(random.createNumber())) {
                outputView.printForEach(cars.get(car), cars.get(car).moveForward());
                continue;
            }
            outputView.printForEach(cars.get(car), cars.get(car).moveStop());
        }
    }
}
