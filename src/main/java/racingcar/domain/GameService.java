package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameService {
    private final UserInput userInput;
    private final ContainerSetting containerSetting;
    private final SystemOutput systemOutput;

    public GameService(UserInput userInput, ContainerSetting containerSetting, SystemOutput systemOutput) {
        this.userInput = userInput;
        this.containerSetting = containerSetting;
        this.systemOutput = systemOutput;
    }

    public void run(String input, String gameNum) {
        System.out.println(Constants.RESULT_OF_GAME);

        List<String> carList = userInput.askCarList(input);
        Map<String, Integer> numMoveMap = containerSetting.initMap(carList);

        printMoveGameNumber(userInput.askNumberGame(gameNum), carList, numMoveMap);

        List<String> winnerList = getWinner(numMoveMap);
        systemOutput.printOverallResult(new WinnerList(winnerList));
    }

    private void printMoveGameNumber(int gameNumber, List<String> carList, Map<String, Integer> numMoveMap) {
        for (int i = 0; i < gameNumber; i++) {
            numMoveMap = containerSetting.decideIncMove(carList, numMoveMap);
            systemOutput.printMoveResult(new MoveContainer(numMoveMap));
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