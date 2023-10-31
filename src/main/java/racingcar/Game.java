package racingcar;

import java.util.List;
import racingcar.view.Announcer;
import racingcar.view.Viewer;

public class Game {
    private final int MOVING_FORWARD = 4;
    private List<Car> carList;
    private final Announcer announcer;
    private final CarGenerator carGenerator;
    private final RandomNumberGenerator randomNumberGenerator;
    private final Viewer viewer;

    public Game(Announcer announcer, CarGenerator carGenerator, RandomNumberGenerator randomNumberGenerator,
                Viewer viewer) {
        this.announcer = announcer;
        this.carGenerator = carGenerator;
        this.randomNumberGenerator = randomNumberGenerator;
        this.viewer = viewer;
    }

    public void init() {
        announcer.announceToInputCarName();
        carList = carGenerator.generate(viewer.inputCarNames());
        announcer.announceToInputTryCount();
    }

    public void play() {
        int tryCount = viewer.inputTryCount();
        announcer.announceResultComment();

        for (int i = 0; i < tryCount; i++) {
            playRound();
        }
    }

    private void playRound() {
        carList.forEach(this::moveCar);
        announcer.announceRaceRound(carList);
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
