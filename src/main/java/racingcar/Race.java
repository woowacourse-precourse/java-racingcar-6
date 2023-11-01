package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Race {
    // 조건에 따라 각 자동차 전진, 정지 시키는 메소드
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

    // 전진, 정지 조건 메소드
    public static boolean forward() {
        int number = Randoms.pickNumberInRange(0,9);

        if(number < 4) {
            return false;
        } else {
            return true;
        }
    }
}
