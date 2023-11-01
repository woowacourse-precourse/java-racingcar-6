package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class RacingGame {
    public void start() {
        Output.tellStartAndWantName();
        String[] userName = Input.getCarName();
        HashMap<String, Integer> userInfo = new HashMap<>(userName.length);
        userGetZeroBase(userInfo, userName);
        int gameRoundNum = playRound(userInfo, userName);
        int numOfWinnerGoNum = Output.findNumOfWinner(userInfo, userName, gameRoundNum);
        Output.showWinner(Output.findWinner(userInfo, userName, numOfWinnerGoNum));
    }

    void countGo(HashMap userInfo, String[] userName) {
        for (String name : userName) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                userInfo.put(name, (Integer) userInfo.get(name) + 1);
            }
        }
    }

    void userGetZeroBase(HashMap userInfo, String[] userName) {
        for (String name : userName) {
            userInfo.put(name, 0);
        }
    }

    int playRound(HashMap userInfo, String[] userName) {
        int currentRoundNum = 0;
        Output.tellHowManyRoundWant();
        int gameRoundNum = Input.getGameRoundNum();

        while (gameRoundNum != currentRoundNum) {
            countGo(userInfo, userName);
            Output.userCondition(userInfo, userName);
            currentRoundNum += 1;
            System.out.println();
        }
        return gameRoundNum;
    }
}




