package racingcar;

import racingcar.Constant.*;

public class RacingCarGame {
    private  UserInputHandler userInputHandler;
    RacingCarGame(){
        this.userInputHandler = new UserInputHandler();
    }

    public void play(){

    }

    private void initConfig(){
        System.out.println(UserRequesMessage.CAR_NAME_REQUEST_MESSAGE);
        initCar();

        System.out.println(UserRequesMessage.Repeat_REQUEST_MESSAGE);
    }

    private void initCar(){
        //userInputHandler.getCarNames();
    }

}
