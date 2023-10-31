package racingcar.controller;

import racingcar.View.InputMessage;
import racingcar.View.SystemMessage;
import racingcar.model.CarAction;
import racingcar.model.Cars;
import racingcar.model.Referee;
import racingcar.util.ExceptionHandling;


public class GameController {
    private final CarAction carAction = new CarAction();
    private final Referee referee = new Referee();
    private int count;

    public void playGame() {
        getCarName();
        getCount(InputMessage.requestGameNumber());
        SystemMessage.printResultStart();
        for (int i = 0; i < count; i++) {
            playOneGame();
        }
        SystemMessage.printWinner(referee.selectWinners());
    }

    private void playOneGame() {
        carAction.moveCars();
        for (int i = 0; i < Cars.countList.size(); i++) {
            SystemMessage.printOneGameResult(Cars.carList.get(i), Cars.countList.get(i));
        }
        System.out.println();
    }

    private void getCarName() {
        Cars cars = new Cars(InputMessage.requestCarsName());
    }

    private void getCount(String InputCount) {
        ExceptionHandling.isNumberValid(InputCount);
        ExceptionHandling.isNumberZero(InputCount);
        count = Integer.parseInt(InputCount);
    }


}
