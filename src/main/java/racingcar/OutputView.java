package racingcar;

import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    void showRacingResult(Map<String, Integer> record){
        for(Entry<String, Integer> entrySet: record.entrySet()){
            Integer number = entrySet.getValue();
            StringBuilder sb = new StringBuilder();

            while(sb.length() < number){
                sb.append("-");
            }

            String result = sb.toString();
            System.out.println(String.format("%s : %s", entrySet.getKey(), result));
        }
    }
}
