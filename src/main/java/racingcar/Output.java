package racingcar;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Output {
    static final String WINNER_IS = "최종 우승자 : ";
    void printResultOfRound(ConcurrentHashMap<String, Integer> carMap){
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String, Integer> entry : carMap.entrySet()){
            sb.append(entry.getKey())
            .append(" : ")
            .append(IntegerValueToDash(entry.getValue()));

            System.out.println(sb);
            sb.setLength(0);
        }

        System.out.println();
    }

    String IntegerValueToDash(Integer distance){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < distance; i++){
            sb.append("-");
        }
        return sb.toString();
    }

    void printWinner(ArrayList<String> winner){
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER_IS);
        sb.append(String.join(",",winner));
        System.out.println(sb);
    }
}
