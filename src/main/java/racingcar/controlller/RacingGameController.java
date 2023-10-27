package racingcar.controlller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.OutputView;

public class RacingGameController extends GameController {
    public RacingGameController(boolean isRunning) {
        super(isRunning);
    }

    @Override
    public void init() {
        // 게임 시작 전 필요한 사전 작업 진행
    }

    @Override
    public void run() {
        init();
        while (isRunning) {
            startGame();
        }
    }

    @Override
    public void startGame() {
        Cars cars = RacingGameInputController.scanCarList();
        int numberOfRounds = RacingGameInputController.scanNumberOfRounds();

        OutputView.printResultHeaderMessage();
        for (int i = 0; i < numberOfRounds; i++) {
            doOneRound(cars);
            OutputView.printCurrentForwardState(cars);
        }
        OutputView.printWinners(pickWinners(cars));

        endGame();
    }

    private void doOneRound(Cars cars) {
        for (Car car : cars.getCarList()) {
            moveOrNot(car);
        }
    }

    private void moveOrNot(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.moveForward(1);
        }
    }

    private Cars pickWinners(Cars cars) {
        Car winner1 = cars.getCarList().stream()
                .max(Comparator.comparingInt(Car::getPosition)).get();
        List<Car> winnerList = cars.getCarList().stream()
                .filter(car -> car.getPosition() == winner1.getPosition())
                .toList();
        return new Cars(winnerList);
    }

    private void endGame() {
        isRunning = false;
    }
}
