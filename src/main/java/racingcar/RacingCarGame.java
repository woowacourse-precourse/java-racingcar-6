package racingcar;

import racingcar.Constant.*;

public class RacingCarGame {
    private UserInputHandler userInputHandler;
    RacingCarGame(){
        this.userInputHandler = new UserInputHandler();
    }

    public void play(){
        initConfig();
    }

    private void initConfig(){
        System.out.println(UserRequestMessage.CAR_NAME_REQUEST_MESSAGE);
        initCar();

        System.out.println(UserRequestMessage.Repeat_REQUEST_MESSAGE);
    }

    private void initCar(){
        String [] names = userInputHandler.getInputForNames();
        System.out.println(names);
    }

}
