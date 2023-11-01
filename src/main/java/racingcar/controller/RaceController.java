package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.UserInputValidation;

public class RaceController {
    InputView input = new InputView();
    CarController carController = new CarController();
    UserInputValidation userInputValidation = new UserInputValidation();

    public void startRace() {
        List<String> carList = carController.makeCarList(input.inputCarNames());
        String attemptNumber = input.inputAttemptNumber();
        userInputValidation.checkAttemptNumberValidation(attemptNumber);

        List<Car> cars = carController.makeCarObjectList(carList);
        repeatForward(Integer.parseInt(attemptNumber), cars);

        showWhoIsWinner(cars);
    }

    private void repeatForward(int attemptNumber, List<Car> cars) {
        for (int i = 0; i < attemptNumber; i++) {
            race(cars);
        }
    }

    public void race(List<Car> cars) {
        for (Car car : cars) {
            int moveNum = Randoms.pickNumberInRange(0, 9);
            ;
            if (carController.canMove(moveNum)) {
                car.move();
            }
        }
        carController.showCurrentPosition(cars);
    }

    public void showWhoIsWinner(List<Car> cars) {
        StringBuilder winner = new StringBuilder();

        List<String> winnerList = carController.calculateWinner(cars);
        for (String winnerName : winnerList) {
            if (!winner.isEmpty()) {
                winner.append(",");
            }
            winner.append(winnerName);
        }

        System.out.println("최종 우승자 : " + winner.toString());
    }
}
