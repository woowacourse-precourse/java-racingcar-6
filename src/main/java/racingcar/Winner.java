package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Winner {

    public static List<String> pickWinners(Map<String, List<String>> raceResultHMap){
        Set<Map.Entry<String, List<String>>> raceResultES = raceResultHMap.entrySet();
        int maxRaceResultSize = 0;
        List<String> winners = new ArrayList<>();

        for(var entry : raceResultES){
            List<String> eachCarRaceResult = entry.getValue();
            if(eachCarRaceResult.size() >= maxRaceResultSize){
                maxRaceResultSize = eachCarRaceResult.size();
                String winner = entry.getKey();
                winners.add(winner);
            }
        }

        return winners;
    }



    public static void showWinners(List<String> winnersArrayList){
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winnersArrayList.size(); i++){
            System.out.print(winnersArrayList.get(i));
            if(i < winnersArrayList.size() -1){
                System.out.print(", ");
            }
        }
    }

}

