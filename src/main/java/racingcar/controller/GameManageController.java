package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManageController {

    private List<Car> carList = new ArrayList<Car>();

    public void play() {
        OutputView.enterCarNames();
        String names = InputView.inputCarNames();
        List<String> namesList = List.of(names.split(","));

        for (String name : namesList) {
            Car car = new Car(name);
            carList.add(car);
        }

        OutputView.enterAttempts();
        int attempts = InputView.inputAttempts();
        showResult(attempts);

    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<Car>();
        int maxPosition = findMaxPosition();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private void showResult(int attempts) {
        OutputView.printResultMessage();
        for (int i = 0; i < attempts; i++) {
            for (Car car : carList) {
                int moveCommand = Randoms.pickNumberInRange(0, 9);
                car.move(moveCommand);
            }
            OutputView.printResult(carList);
        }
        List<Car> winners = findWinners();
        OutputView.printWinners(winners);
    }
}
