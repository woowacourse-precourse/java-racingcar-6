package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Model;
import racingcar.model.Rank;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        List<String> participants = getParticipantsFromUser();
        List<Car> cars = generateCarList(participants);

        updateAndRecordCarStatus(cars);

        judgeAndRecordWinner(cars);

        outputView.printResult();
    }

    private List<String> getParticipantsFromUser() {
        return inputView.getUserInputName();
    }

    private List<Car> generateCarList(List<String> participants) {
        List<Car> cars = new ArrayList<>();
        for (String name:participants) {
            cars.add(Model.generateCar(name));
        }
        return cars;
    }

    private void updateAndRecordCarStatus(List<Car> cars) {
        int tryCount = inputView.getUserInputCount();
        while (tryCount-- > 0) {
            cars.forEach(Car::moveOrStop);
            outputView.recordStatus(cars);
        }
    }

    private void judgeAndRecordWinner(List<Car> cars) {
        Rank rank = Model.generateRank(cars);
        outputView.recordWinner(rank.getWinnerList());
    }
}
