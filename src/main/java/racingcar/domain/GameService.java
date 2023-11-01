package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameService {
    UserInput userInput = new UserInput();
    MoveContainer moveContainer = new MoveContainer();

    SystemOutput systemOutput = new SystemOutput();

    public void run(String input, String gameNum) {

        System.out.println(Constants.RESULT_OF_GAME);

        List<String> carList = userInput.askCarList(input);
        Map<String, Integer> numMoveMap = moveContainer.initMap(carList);

        printMoveGameNumber(userInput.askNumberGame(gameNum), carList, numMoveMap);

        List<String> winnerList = getWinner(numMoveMap);
        systemOutput.printOverallResult(winnerList);

    }

    private void printMoveGameNumber(int gameNumber, List<String> carList, Map<String, Integer> numMoveMap){
        for (int i = 0; i < gameNumber; i++) {
            numMoveMap = moveContainer.decideIncMove(carList, numMoveMap);
            systemOutput.printMoveResult(numMoveMap);
        }
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
