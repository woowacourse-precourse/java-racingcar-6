package racingcar.ouput;

import racingcar.carRacingGame.FinalWinner;

import java.util.List;
import java.util.Map;

public class FinalWinnerOuput {

    FinalWinner finnerWinner = new FinalWinner();
    public void finalWinnerOuput(Map<String, Integer> carNameMap, List<String> carNameList, int gameResult) {
        System.out.println("최종 우승자 : " + finnerWinner.finalWinner(carNameMap,carNameList, gameResult));
    }
}
