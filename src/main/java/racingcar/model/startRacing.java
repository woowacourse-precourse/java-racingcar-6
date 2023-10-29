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


}
