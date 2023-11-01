package service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import model.CarList;
import model.Message;

public class RacingGame {

    private final GameProcessor gameProcessor = new GameProcessor();

    public void gameStart(){
        System.out.println(Message.GAMESTART);

        CarList carList = gameProcessor.namingCar();
        int round = gameProcessor.setRound();


    }






}
