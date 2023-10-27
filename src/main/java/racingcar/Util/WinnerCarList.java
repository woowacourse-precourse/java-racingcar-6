package racingcar.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerCarList {

    private static List<String> winnerList;
    public static List<String> winnerCarList(List<String> carList, List<Integer> goAndStop) {
        findWinner(carList, goAndStop);
        return winnerList;
    }

    private static void findWinner(List<String> carList, List<Integer> goAndStop) {
        winnerList = new ArrayList<>();
        int maxStopAndGo = Collections.max(goAndStop);
        for (int i = 0; i < goAndStop.size(); i++) {
            if(maxStopAndGo==goAndStop.get(i)){
                winnerList.add(carList.get(i));
            }
        }
    }
}
