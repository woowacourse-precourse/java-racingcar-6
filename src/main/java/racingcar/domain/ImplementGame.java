package racingcar.domain;

import java.util.List;
import java.util.Map;

public class ImplementGame {
    UserInput userInput = new UserInput();
    SaveMoveLog saveMoveLog = new SaveMoveLog();

    public Map<String, Integer> playGame(){
        List<String> carList = userInput.askCar();
        int gameNumber = userInput.askNumberGame();
        System.out.println("경기 실행 결과:");
        Map<String, Integer> numMoveMap = saveMoveLog.initMap(carList);
        for (int i = 0; i < gameNumber; i++){
            numMoveMap = saveMoveLog.decideIncMove(carList, numMoveMap);
            saveMoveLog.printMoveResult(numMoveMap);
        }
        return numMoveMap;
    }

}
