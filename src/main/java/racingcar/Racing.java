package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import utils.CarRaceLog;

import java.util.ArrayList;

public class Racing {
    public static void runRace(ArrayList<String> carDistanceList) {
        for (int i = 0 ; i < carDistanceList.size(); i++) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                CarRaceLog.updateCarDistanceList(i, carDistanceList);
            }
            System.out.println(carDistanceList.get(i));
        }
    }

    public static void startGame(int tryCount, ArrayList<String> carDistanceList) {
        while (tryCount > 0) {
            tryCount -= 1;
            runRace(carDistanceList);
        }
    }
}
