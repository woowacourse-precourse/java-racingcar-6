package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.dto.GameInput;
import racingcar.model.dto.GameResult;
import racingcar.model.dto.GameStatus;
import racingcar.view.OutputView;

public class Game {

    private List<Car> cars;

    private Long totalTurns;

    private Long currentTurn;

    public Game(GameInput input) {
        this(input.carNames(), input.totalTurns(), 0L);
    }

    private Game(List<String> carNames, Long totalTurns, Long currentTurn) {
        if (carNames == null) {
            throw new IllegalArgumentException("carNames must not be null");
        }
        if (totalTurns == null) {
            throw new IllegalArgumentException("totalTurns must not be null");
        }
        if (currentTurn == null) {
            throw new IllegalArgumentException("currentTurn must not be null");
        }

        this.cars = GameUtils.carFactory(carNames);
        this.totalTurns = totalTurns;
        this.currentTurn = currentTurn;
    }

    public void play() {

        for(currentTurn = 0L; currentTurn < totalTurns; currentTurn++) {
            turn();
        }
        OutputView.printWinner(GameResult.fromCars(cars));
    }

    private void turn() {
        for(Car car : cars) {
            if (GameUtils.isForward()) {
                car.foward();
            }
            OutputView.printStatus(GameStatus.fromCar(car));
        }
    }


}
