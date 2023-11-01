package service;

import camp.nextstep.edu.missionutils.Console;
import model.Car;
import model.CarList;
import model.Round;
import model.RoundSet;

import java.util.List;

public class GameProcessor {

    private final ProcessHelper processHelper = new ProcessHelper();
    private final Validation validation = new Validation();
    public CarList namingCar(){
        String[] carNameArray = processHelper.commaSeperate(Console.readLine());
        return processHelper.makeCarList(carNameArray);
    }

    public int setRound(){
        String roundInput = validation.roundInputValidation(Console.readLine());
        return Integer.parseInt(roundInput);
    }

    public RoundSet printRoundResult(RoundSet roundSet){

        for(int i = 0; i < roundSet.getRound(); i ++){
            List<Car> carListTmp = processHelper.raceCars(roundSet.getCarList());
            processHelper.printRaceResultByRound(carListTmp);
        }
        return roundSet;
    }

    public void winnerJudgement(List<Car> carList){


    }
}
