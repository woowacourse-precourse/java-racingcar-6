package racingcar.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {

    private static List<String> winnerList;

    public static List<String> carList(List<String> carList, List<Integer> location) {
        find(carList, location);
        return winnerList;
    }

    private static void find(List<String> carList, List<Integer> location) {
        winnerList = new ArrayList<>();
        int maxLocation = Collections.max(location);
        for (int i = 0; i < location.size(); i++) {
            if (maxLocation == location.get(i)) {
                winnerList.add(carList.get(i));
            }
        }
    }
}
