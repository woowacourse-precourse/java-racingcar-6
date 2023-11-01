package racingcar.controller;
import racingcar.model.Car;
import racingcar.view.InputUser;


import java.util.ArrayList;

public class RacingGame {
    private int roundLength;

    public RacingGame(){
        roundLength=0;
    }

    public void gamePlay(){
        InputUser inputUser = new InputUser();
        inputUser.inputCarNameString();
        ArrayList<Car> carList = inputUser.returnCar();

        roundLength=inputUser.inputRoundLength();

        Round round = new Round(roundLength);
        round.playRound(carList);
    }

}
