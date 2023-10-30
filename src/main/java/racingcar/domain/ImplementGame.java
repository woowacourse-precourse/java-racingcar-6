package racingcar.domain;

import java.util.List;
import java.util.Map;

import static racingcar.domain.Constants.*;

public class ImplementGame {
    UserInput userInput = new UserInput();
    SaveMoveLog saveMoveLog = new SaveMoveLog();

    public Map<String, Integer> playGame(){
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        List<String> carList = userInput.askCar();
        System.out.println(ATTEMP_INPUT_MESSAGE);
        int gameNumber = userInput.askNumberGame();
        System.out.println(RESULT_OF_GAME);
        Map<String, Integer> numMoveMap = saveMoveLog.initMap(carList);
        for (int i = 0; i < gameNumber; i++){
            numMoveMap = saveMoveLog.decideIncMove(carList, numMoveMap);
            saveMoveLog.printMoveResult(numMoveMap);
        }
        return numMoveMap;
    }

}
