package controller;

import controller.dto.CarNames;
import controller.dto.MoveResult;
import java.util.List;
import model.Car;
import model.Cars;
import model.RandomReferee;
import model.Referee;
import model.TryCount;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final Referee referee;
    private Cars cars;
    private TryCount tryCount;

    public RacingGameController(final OutputView outputView, final InputView inputView,
        final Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.referee = referee;
    }

    public static RacingGameController createDefault(final OutputView outputView,
        final InputView inputView) {
        return new RacingGameController(outputView, inputView, new RandomReferee());
    }

    public static RacingGameController createControllerWithReferee(final OutputView outputView,
        final InputView inputView, final Referee referee) {
        return new RacingGameController(outputView, inputView, referee);
    }

    public void run() {
        initGame();
    }

    private void initGame() {
        initCars();
        initTryCount();
        startRace();
    }

    private void startRace() {
        outputView.informBeforeResult();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            moveCars();
        }
    }

    private void moveCars() {
        cars.actEachCar(this::moveCarByReferee);
        List<MoveResult> moveResults = cars.getMoveResult();
        outputView.informResult(moveResults);
    }

    private void moveCarByReferee(Car car) {
        if (!referee.isSatisfiedCondition()) {
            return;
        }
        car.moveForward();
    }

    private void initCars() {
        outputView.askCarNames();
        CarNames carNames = CarNames.of(inputView.readLine());
        cars = carNames.toCars();
    }

    private void initTryCount() {
        outputView.askTryCount();
        tryCount = TryCount.from(inputView.readLine());
    }
}
