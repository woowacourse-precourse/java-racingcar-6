package controller;

import constant.*;
import racingcar.CarController;
import racingcar.UserInputHandler;

public class RacingCarGameController {
    private UserInputHandler userInputHandler;
    private CarController carController;
    private int moveCount;
    RacingCarGameController(){

        this.userInputHandler = new UserInputHandler();
        this.carController = new CarController();
    }

    public void play(){
        initConfig();
        System.out.println("\n"+ UserResponeMessage.EXECUTION_RESULT_MESSAGE);

        // 라운드 진행
        for(int rount = 0; rount < moveCount; rount++){
            carController.grantForwardChanceForCars();
            carController.printRoundResult();
        }

        announceWinners();
    }

    private void initConfig(){
        System.out.println(UserRequestMessage.CAR_NAME_REQUEST_MESSAGE);
        initializeCars();
        System.out.println(UserRequestMessage.Repeat_REQUEST_MESSAGE);
        moveCount = userInputHandler.getInputForMoveCount();
    }

    private void initializeCars(){
        String [] carNames = userInputHandler.getInputForNames();
        carController.initializeOperatedCars(carNames);
    }

    private void announceWinners(){
        carController.determineWinner();
    }

}
