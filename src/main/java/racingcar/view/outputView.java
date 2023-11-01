package racingcar.view;

import java.util.List;
import java.util.Map;

public class outputView {

    public static void printOutput(Map<String,String> result){
        for (String key : result.keySet()){
            System.out.println( key + " : " + result.get(key));
        }
        System.out.println();
    }


    public static void printWinners(List<String> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : "+winners.get(0) );
        } else {
            String winnerNames = String.join(", ", winners);
            System.out.println("최종 우승자 : "+ winnerNames);
        }
    }


}
