package service;

import camp.nextstep.edu.missionutils.Console;
import model.*;

import java.util.ArrayList;
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
            System.out.println();
        }
        return roundSet;
    }

    public StringBuilder winnerJudgement(List<Car> carList){
        CarScore carScore = new CarScore();
        for(Car car : carList){
           carScore.addCarScore(car.getForwardCount());
        }

        List<Integer> maxIndices = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < carScore.getCarScore().size(); i++) {
            int currentValue = carScore.getCarScore().get(i);
            if (currentValue > maxValue) {
                maxValue = currentValue;
                maxIndices.clear();
                maxIndices.add(i);
            } else if (currentValue == maxValue) {
                maxIndices.add(i);
            }
        }

        StringBuilder winner = new StringBuilder();
        for(Integer tmpIndex : maxIndices){
            if(winner.isEmpty()){
                winner.append(carList.get(tmpIndex).getCarName());
            }
            else if(!winner.isEmpty()){
                winner.append(", ").append(carList.get(tmpIndex).getCarName());
            }
        }
        return winner;
    }
}
