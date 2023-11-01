package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputUser;

import java.util.ArrayList;

public class RacingGame {
    private final InputUser inputUser;
    private ArrayList<Car> carList;
    private int roundLength;

    public RacingGame() {
        roundLength = 0;
        inputUser = new InputUser();
        carList = null;
    }

    public void gamePlay() {
        inputUser.inputCarNameString();
        carList = inputUser.returnCar();

        roundLength = inputUser.inputRoundLength();

        Round round = new Round(roundLength);
        round.playAllRound(carList);
    }

}
