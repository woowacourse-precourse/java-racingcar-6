package racingcar;

import racingcar.Constant.*;

public class RacingCarGame {
    private UserInputHandler userInputHandler;
    private CarController carController;
    private int moveCount;
    RacingCarGame(){

        this.userInputHandler = new UserInputHandler();
        this.carController = new CarController();
    }

    public void play(){
        initConfig();
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

}
