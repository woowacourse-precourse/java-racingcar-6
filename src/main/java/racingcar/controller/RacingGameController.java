package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Model;
import racingcar.model.Rank;
import racingcar.util.InputValidator;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.View;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    RacingGameController() {
        InputValidator inputValidator = Validator.generateInputValidator();
        this.inputView = View.generateInputView(inputValidator);
        this.outputView = View.generateOutputView();
    }

    public void gameStart() {
        List<String> participants = inputView.getUserInputName();
        int tryCount = inputView.getUserInputCount();

        List<Car> cars = new ArrayList<>();
        for (String name:participants) {
            cars.add(Model.generateCar(name));
        }

        while (tryCount-- > 0) {
            cars.forEach(Car::moveOrStop);
            outputView.recordStatus(cars);
        }

        Rank rank = Model.generateRank(cars);
        outputView.recordWinner(rank.getWinnerList());
        outputView.printResult();
    }
}
