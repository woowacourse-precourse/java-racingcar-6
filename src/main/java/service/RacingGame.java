package service;

import model.CarList;
import model.Message;
import model.Round;
import model.RoundSet;

public class RacingGame {

    private final GameProcessor gameProcessor = new GameProcessor();

    public RoundSet gameStart(){
        System.out.println(Message.SETCARNAME);
        CarList carList = gameProcessor.namingCar();

        System.out.println(Message.SETROUND);
        Round round = new Round(gameProcessor.setRound());

        return new RoundSet(carList, round);
    }

    public void gameProcess(RoundSet roundSet){
        System.out.println(Message.RESULT);
        gameProcessor.printRoundResult(roundSet);
    }


    public void printWinner(RoundSet roundSet){
        System.out.println(Message.GAMEEND);
        gameProcessor.winnerJudgement(roundSet.getCarList());
    }




}
