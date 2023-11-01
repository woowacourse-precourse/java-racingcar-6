package racingcar;

import racingcar.domain.Race;
import racingcar.domain.Referee;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.util.CarGenerator;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Race race;
    private final Referee referee;
    private List<Car> cars;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.race = new Race();
        this.referee = new Referee();
        this.cars = new ArrayList<>();
    }

    public void play() {
        outputView.displayStartMessage();
        List<String> carNames = inputView.getCarNames();
        createCars(carNames);

        outputView.displayGetMoveCount();
        int moveCount = inputView.getMoveCount();

        runRace(moveCount);

        List<String> winner = referee.determineWinner(cars);
        outputView.displayWinner(winner);
    }

    private void createCars(List<String> carNames) {
        for (String name : carNames) {
            Car car = CarGenerator.createCar(name);
            cars.add(car);
        }
    }

    private void runRace(int moveCount) {
        outputView.displayRaceMessage();
        while (moveCount > 0) {
            race.moveCars(cars);
            outputView.displayRaceStatus(cars);
            moveCount--;
        }
    }
}