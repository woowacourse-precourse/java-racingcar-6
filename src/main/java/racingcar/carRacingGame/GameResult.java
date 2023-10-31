package racingcar.carRacingGame;

import racingcar.ouput.FinalWinnerOuput;

import java.util.List;
import java.util.Map;

public class GameResult {
    MoveOrStop moveOrStop = new MoveOrStop();
    FinalWinnerOuput finalWinnerOuput = new FinalWinnerOuput();
    public void gameResult(List<String> carNameList, Map<String, Integer> carNameMap, int tryNumber) {
        System.out.println("실행 결과");

        for (int i = 0; i < tryNumber-1; i++) {
            printResult(carNameList, carNameMap);
            System.out.println();
        }
        printResultAndGetMaxResult(carNameList, carNameMap);

    }

    public void printResult(List<String> carNameList, Map<String, Integer> carNameMap){
        moveOrStop.moveOrStop(carNameMap);
        for (String carName : carNameList) {
            int moveLength = carNameMap.get(carName);
            String move = "-";
            System.out.println(carName + " : " + move.repeat(moveLength));
        }
    }
    public void printResultAndGetMaxResult(List<String> carNameList,Map<String, Integer> carNameMap){
        moveOrStop.moveOrStop(carNameMap);
        int maxLength = 0;

        for (String carName : carNameList) {
            int moveLength = carNameMap.get(carName);
            String move = "-";
            System.out.println(carName + " : " + move.repeat(moveLength));
            if (maxLength < moveLength) maxLength = moveLength;
        }
        System.out.println();
        finalWinnerOuput.finalWinnerOuput(carNameMap,carNameList, maxLength);
    }



}


