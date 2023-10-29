package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Racing {

    static Map<String, Integer> makeRecord(String[] cars){
        Map<String, Integer> record = new HashMap<>();
        for(String car:cars){
            record.put(car,0);
        }
        return record;
    }

}
