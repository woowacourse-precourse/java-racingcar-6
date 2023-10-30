package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Manager;
import racingcar.view.OutputView;

public class RacingCarController {
    private RegisterController registerController;

    public RacingCarController(){
        this.registerController = new RegisterController();
    }

    public void run(){
        Manager manager = registerController.registerCar();
        OutputView.outputResultMessage();
        do {
            manager.manageMoveOneCycle();

            for(Car car : manager.getCarList()){
                OutputView.outputCarAndScore(car.getName(), car.getScore());
            }
            System.out.println();

        }while(manager.getMoveCount()>0);

        OutputView.outputWinner(manager.resultWinner());

    }
}
