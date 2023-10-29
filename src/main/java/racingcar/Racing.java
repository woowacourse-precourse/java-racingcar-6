package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Racing {

    static Map<String, Integer> makeRecord(String[] cars){
        Map<String, Integer> record = new HashMap<>();
        for(String car:cars){
            record.put(car,0);
        }
        return record;
    }

    static void recordResult(Map<String, Integer> record){
        for(Entry<String, Integer> entrySet: record.entrySet()){
            int randomNum = Util.makeRandomNumber();

            if(Util.decideMovement(randomNum)){
                int num = entrySet.getValue() + 1;
                record.put(entrySet.getKey(), num);
            }
        }
    }

}
