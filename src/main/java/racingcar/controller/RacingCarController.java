package racingcar.controller;

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
            manager.manageOneCycle();

            for(Car car : manager.getCarList()){
                OutputView.outputCarAndScore(car.getName(), car.getMovementScore());
            }
            System.out.println();

        }while(manager.getRemainingCycle()>0);

        OutputView.outputWinner(manager.announceWinner());

    }
}
