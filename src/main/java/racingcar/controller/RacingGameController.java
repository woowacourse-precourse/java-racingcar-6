package racingcar.controller;

import static racingcar.util.ConstantNumbers.MINIMUM_TRY_COUNT;
import static racingcar.util.ConstantNumbers.STARTING_INDEX;

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
        List<Car> cars = generateCarList();

        updateRaceStatus(cars);

        judgeWinner(cars);

        outputView.printResult();
    }

    private List<String> getParticipantsFromUser() {
        return inputView.getUserInputName();
    }

    private List<Car> generateCarList() {
        List<String> participants = getParticipantsFromUser();

        List<Car> cars = new ArrayList<>();
        int index = STARTING_INDEX.number();
        for (String name:participants) {
            cars.add(Model.generateCar(name, index++));
        }
        return cars;
    }

    private void updateRaceStatus(List<Car> cars) {
        int tryCount = inputView.getUserInputCount();
        while (tryCount-- > MINIMUM_TRY_COUNT.number()) {
            cars.forEach(Car::moveOrStop);
            outputView.recordStatus(cars);
        }
    }

    private void judgeWinner(List<Car> cars) {
        Rank rank = Model.generateRank(cars);
        outputView.recordWinner(rank.getWinnerList());
    }
}
