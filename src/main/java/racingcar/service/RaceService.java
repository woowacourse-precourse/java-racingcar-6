package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
import racingcar.utils.ErrorMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceService {

    private final Cars cars;
    private final MoveCount moveCnt;

    public RaceService(String[] carNames, MoveCount moveCnt) {
        this.cars = new Cars(carNames);
        this.moveCnt = moveCnt;
    }

    public List<Car> run() {
        while (moveCnt.isOn()) {
            cars.playSingleTurn();
            OutputView.printCarsMove(cars.carsInformation());
            moveCnt.next();
        }
        return findWinners();
    }

    public static MoveCount getMoveCount() {
        try {
            return new MoveCount(Integer.parseInt(InputView.userInput()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
        }
    }

    private List<Car> findWinners() {
        int currentMaxPosition = cars.getCurrentPosition();
        return cars.findWinner(currentMaxPosition);
    }
}

