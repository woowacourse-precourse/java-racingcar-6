package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Race {
    public static final boolean MOVING_FORWARD = true;
    public static final boolean STOP = false;
    public static HashMap<String, Integer> race(HashMap<String, Integer> map){
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();

            boolean condition = forward();
            if(condition == true) {
                map.replace(key, (value+1));
            }
        }
        return map;
    }

    public static boolean forward() {
        int number = Randoms.pickNumberInRange(0,9);

        if(number < 4) {
            return STOP;
        } else {
            return MOVING_FORWARD;
        }
    }
}
