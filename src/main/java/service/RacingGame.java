package service;

import model.CarList;
import model.Message;
import model.Round;
import model.RoundSet;

public class RacingGame {
    private final GameProcessor gameProcessor = new GameProcessor();

    public RoundSet gameStart(){
        System.out.println(Message.SETCARNAME.getStr());
        CarList carList = gameProcessor.namingCar();

        System.out.println(Message.SETROUND.getStr());
        Round round = new Round(gameProcessor.setRound());

        return new RoundSet(carList, round);
    }
    public RoundSet gameProcess(RoundSet roundSet){
        System.out.println(Message.RESULT.getStr());
        roundSet = gameProcessor.printRoundResult(roundSet);
        return roundSet;
    }
    public void printWinner(RoundSet roundSet){
        System.out.print(Message.GAMEEND.getStr());
        System.out.println(gameProcessor.winnerJudgement(roundSet.getCarList()));
    }
}
