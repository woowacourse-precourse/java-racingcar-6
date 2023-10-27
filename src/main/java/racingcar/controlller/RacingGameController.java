package racingcar.controlller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.OutputView;

public class RacingGameController extends GameController {
    private CarList carList;
    private int numberOfRounds;

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
        carList = RacingGameInputController.scanCarList();
        numberOfRounds = RacingGameInputController.scanNumberOfRounds();

        OutputView.printResultHeaderMessage();
        for (int i = 0; i < numberOfRounds; i++) {
            doOneRound();
            OutputView.printCurrentForwardState(carList);
        }
        OutputView.printWinners(getWinners(carList));

        endGame();
    }

    private void doOneRound() {
        for (Car car : carList.getCarList()) {
            moveOrNot(car);
        }
    }

    private void moveOrNot(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.moveForward(1);
        }
    }

    private CarList getWinners(CarList carList) {
        Car winner1 = carList.getCarList().stream()
                .max(Comparator.comparingInt(Car::getPosition)).get();
        List<Car> winnerList = carList.getCarList().stream()
                .filter(car -> car.getPosition() == winner1.getPosition())
                .toList();
        return new CarList(winnerList);
    }

    private void endGame() {
        isRunning = false;
    }
}
