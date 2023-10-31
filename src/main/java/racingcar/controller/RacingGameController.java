package racingcar.controller;

import static racingcar.util.ConstantNumbers.MINIMUM_TRY_COUNT;
import static racingcar.util.ConstantNumbers.STARTING_INDEX;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Model;
import racingcar.model.CarRank;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.View;

public class RacingGameController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;

    RacingGameController(final View inputView, final View outputView) {
        this.inputView = (InputView) inputView;
        this.outputView = (OutputView) outputView;
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
        for (String name : participants) {
            cars.add((Car) Model.generateCar(name, index++));
        }

        return cars;
    }

    private void updateRaceStatus(final List<Car> cars) {
        int tryCount = inputView.getUserInputCount();
        while (tryCount-- > MINIMUM_TRY_COUNT.number()) {
            cars.forEach(Car::moveOrStop);
            outputView.recordStatus(cars);
        }
    }

    private void judgeWinner(final List<Car> cars) {
        CarRank carRank = (CarRank) Model.generateRank(cars);
        outputView.recordWinner(carRank.getWinnerList());
    }
}
