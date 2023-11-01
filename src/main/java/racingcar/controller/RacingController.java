package racingcar.controller;

import static racingcar.util.ConstantNumbers.MINIMUM_TRY_COUNT;
import static racingcar.util.ConstantNumbers.STARTING_INDEX;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Model;
import racingcar.model.CarRank;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;
import racingcar.view.View;

public class RacingController implements Controller {
    private final RacingInputView racingInputView;
    private final RacingOutputView racingOutputView;

    RacingController(final View inputView, final View outputView) {
        this.racingInputView = (RacingInputView) inputView;
        this.racingOutputView = (RacingOutputView) outputView;
    }

    /**
     * 자동차 경주 게임을 시작하는 메서드.
     */
    public void gameStart() {
        List<Car> cars = generateCarList();

        updateRaceStatus(cars);

        judgeWinner(cars);

        racingOutputView.printResult();
    }

    private List<String> getParticipantsFromUser() {
        return racingInputView.getUserInputName();
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
        int tryCount = racingInputView.getUserInputCount();
        while (tryCount-- > MINIMUM_TRY_COUNT.number()) {
            cars.forEach(Car::moveOrStop);
            racingOutputView.recordStatus(getCurrentStatuses(cars));
        }
    }

    private List<String> getCurrentStatuses(final List<Car> cars) {
        List<String> statusList = new ArrayList<>();
        for (Car car:cars) {
            statusList.add(car.toString());
        }

        return statusList;
    }

    private void judgeWinner(final List<Car> cars) {
        CarRank carRank = (CarRank) Model.generateRank(cars);
        racingOutputView.recordWinner(carRank.getWinnerList());
    }
}
