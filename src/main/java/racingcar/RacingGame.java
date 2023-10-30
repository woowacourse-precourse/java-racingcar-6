package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class RacingGame {
    public void start() {
        Output.tellStartAndWantName();
        String[] carName = Input.getCarName();
        // Output.tellGroupName(carName);
        HashMap<String, Integer> userInfo = new HashMap<>(carName.length);
        for (String name : carName) {
            userInfo.put(name, 0);
        }

        int currentRoundNum = 0;
        Output.tellHowManyRoundWant();
        int gameRoundNum = Input.getGameRoundNum();

        while (gameRoundNum != currentRoundNum) {
            countGo(userInfo, carName);
            Output.tellCurrent(userInfo, carName);
            currentRoundNum += 1;
            System.out.println();
        }
        int numOfWinnerGoNum = Output.findNumOfWinner(userInfo, carName, gameRoundNum);
        Output.showWinner(Output.findWinner(userInfo, carName, numOfWinnerGoNum));

    }

    void countGo(HashMap name, String[] groupName) {
        for (String carName : groupName) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                name.put(carName, (Integer) name.get(carName) + 1);
            }
        }
    }


}



