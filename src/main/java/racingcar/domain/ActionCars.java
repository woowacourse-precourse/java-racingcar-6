package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ActionCars {

    RacingGame racinggame = new RacingGame();
    NumberGenerator numbergenerator = new NumberGenerator();
    OutputView outputview = new OutputView();
    InputView inputview = new InputView();
    CarGenerator cargenerator = new CarGenerator();

    public void gameStart(){
        String winner = "";
        int maxlength = 0;
        int gameChance;
        int carNumbers;

        inputview.printCarNamesInformation();
        cargenerator.inputCarNames();
        inputview.printGameChanceInformation();
        numbergenerator.goChance();
        System.out.println();

        gameChance = racinggame.getGameChance();
        carNumbers = racinggame.getCarNumbers();
        resetCountResult();

        for(int  i = 0 ; i < gameChance; i++){
            carsCycle(carNumbers);
        }
        maxlength = winnerGoCount(carNumbers);

        outputview.printInformation();
        winner = winnerCar(maxlength);
        outputview.printWinner(winner);
    }

    public void carsCycle(int carNumbers){
        for(int  i = 0 ; i < carNumbers; i++){
            numbergenerator.createRandomNumbers();
            int randomNumber = racinggame.getRandomNumber();
            if(randomNumber >= 4){
                goCar(i);
            }
            outputview.printResultGame(racinggame.getCarNames().get(i), racinggame.getCountResult().get(i));
        }
        System.out.println();
    }

    public void goCar(int carNum){
        List<String> countResult = new ArrayList<String>();
        countResult = racinggame.getCountResult();
        String change = countResult.get(carNum);
        change += "-";
        countResult.set(carNum, change); 
    }

    public void resetCountResult(){
        int num = racinggame.getCarNumbers();
        List<String> countResult = new ArrayList<String>();

        for(int i = 0 ; i < num;i++){
            countResult.add("");
        }

        racinggame.setCountResult(countResult);
    }

    public int winnerGoCount(int carNumbers){
        int maxlength = 0;
        for(int i = 0 ; i < carNumbers ; i++){
            if(racinggame.getCountResult().get(i).length() > maxlength){
                maxlength = racinggame.getCountResult().get(i).length();
            }
        }
        return maxlength;
    }

    public String winnerCar(int maxlength){
        List<String> winnerlist = new ArrayList<String>();
        for(int i = 0; i < racinggame.getCarNumbers() ; i++){
            if(racinggame.getCountResult().get(i).length() == maxlength){
                winnerlist.add((String) racinggame.getCarNames().get(i));
            }
        }
        return String.join(", ", winnerlist);
    }
}
