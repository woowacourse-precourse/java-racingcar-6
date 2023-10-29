package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.utils.randomNum;

public class startRacing {

    public void checkRandomNum(HashMap<String, Integer> carNameHashMap) {
        randomNum randomNum = new randomNum();
        Set<String> keySet = carNameHashMap.keySet();

        for (String key : keySet) {
            int randNum = randomNum.makeRandomNum();
            if (randNum >= 4) {
                carNameHashMap.put(key, carNameHashMap.get(key) + 1);
            }
        }
    }

    public void racingResult(HashMap<String, Integer> carNameHashMap) {
        Set<String> keySet = carNameHashMap.keySet();
        for (String key : keySet) {
            int value = carNameHashMap.get(key);
            System.out.print(key + " : ");
            for (int j = 0; j < value; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }


}
