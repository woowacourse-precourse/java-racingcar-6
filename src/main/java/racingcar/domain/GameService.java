package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static racingcar.domain.Constants.*;

public class GameService {
    UserInput userInput = new UserInput();
    MoveContainer moveContainer = new MoveContainer();

    SystemOutput systemOutput = new SystemOutput();

    public void playGame() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        List<String> carList = userInput.askCarList();

        System.out.println(ATTEMP_INPUT_MESSAGE);
        int gameNumber = userInput.askNumberGame();

        System.out.println(RESULT_OF_GAME);
        Map<String, Integer> numMoveMap = moveContainer.initMap(carList);

        for (int i = 0; i < gameNumber; i++) {
            numMoveMap = moveContainer.decideIncMove(carList, numMoveMap);
            systemOutput.printMoveResult(numMoveMap);
        }
        List<String> winnerList = getWinner(numMoveMap);
        systemOutput.printOverallResult(winnerList);
    }

    public static List<String> getWinner(Map<String, Integer> numMap) {
        int maxValue = Collections.max(numMap.values());
        List<String> maxValueKeys = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxValueKeys.add(entry.getKey());
            }
        }
        return maxValueKeys;

    }
}
