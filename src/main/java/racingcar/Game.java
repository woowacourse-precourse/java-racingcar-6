package racingcar;

import static racingcar.History.makeHistory;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.Announcer;
import racingcar.view.InputView;

public class Game {
    private final int MOVING_FORWARD = 4;
    private List<Car> carList;
    private final Announcer announcer;
    private final CarFactory carFactory;
    private final RandomNumberGenerator randomNumberGenerator;
    private final WinnerChecker winnerChecker;
    private final InputView inputView;

    public Game(Announcer announcer, CarFactory carFactory, RandomNumberGenerator randomNumberGenerator,
                WinnerChecker winnerChecker, InputView inputView) {
        this.announcer = announcer;
        this.carFactory = carFactory;
        this.randomNumberGenerator = randomNumberGenerator;
        this.winnerChecker = winnerChecker;
        this.inputView = inputView;
    }

    public void init() {
        announcer.announceToInputCarName();
        carList = carFactory.generate(inputView.inputCarNames());
        announcer.announceToInputTryCount();
    }

    public void play() {
        int tryCount = inputView.inputTryCount();
        List<History> raceResult = race(tryCount);
        announcer.announceRaceHistories(raceResult);
        end();
    }

    private List<History> race(int tryCount) {
        List<History> histories = new ArrayList<>();

        for (int i = 1; i <= tryCount; i++) {
            carList.forEach(this::moveCar);
            histories.add(makeHistory(carList));
        }

        return histories;
    }

    private void end() {
        List<String> winnerList = winnerChecker.getWinnerList(carList);
        announcer.announceWinner(winnerList);
    }

    private void moveCar(Car car) {
        if (isMoveForward()) {
            car.moveForward();
        }
    }

    private boolean isMoveForward() {
        return randomNumberGenerator.generate() >= MOVING_FORWARD;
    }
}
