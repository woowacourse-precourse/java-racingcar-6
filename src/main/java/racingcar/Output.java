package racingcar;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Output {

    void printResultOfRound(ConcurrentHashMap<String, Integer> carMap){
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String, Integer> entry : carMap.entrySet()){
            sb.append(entry.getKey())
            .append(" : ")
            .append(IntegerValueToDash(entry.getValue()));
        }

        System.out.println(sb);
    }

    String IntegerValueToDash(Integer distance){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < distance; i++){
            sb.append("-");
        }
        return sb.toString();
    }
}
