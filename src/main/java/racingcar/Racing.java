package racingcar;

import java.util.ArrayList;
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

    static Map<String, Integer> recordResult(Map<String, Integer> record){
        for(Entry<String, Integer> entrySet: record.entrySet()){
            int randomNum = Util.makeRandomNumber();

            if(Util.decideMovement(randomNum)){
                int num = entrySet.getValue() + 1;
                record.put(entrySet.getKey(), num);
            }
        }
        return record;
    }

    static String[] decideWinner(Map<String, Integer> record){
        ArrayList<String> winner = new ArrayList<>();
        int max = 0;

        for(Entry<String, Integer> entrySet: record.entrySet()){
            if(entrySet.getValue() >= max){
                max = entrySet.getValue();
            }
        }

        for(Entry<String, Integer> entrySet: record.entrySet()){
            String name = entrySet.getKey();
            if(entrySet.getValue() == max){
                winner.add(name);
            }
        }
        return (String[]) winner.toArray();
    }
}
