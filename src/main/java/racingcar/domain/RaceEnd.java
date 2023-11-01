package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceEnd {
    public static StringBuilder winnerResult(Map<String, Integer> car){
        //우승자 판별
        List<String> winnerList = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for(String s : car.keySet()){
            winnerList.add(s);
            if(max < car.get(s)){
                max = car.get(s);
            }
        }

        StringBuilder winnerString = new StringBuilder();
        for(String s : car.keySet()){
            if(car.get(s) < max){
                winnerList.remove(s);
                continue;
            }

            if(winnerString.isEmpty()){
                winnerString.append(s);
            } else if(!winnerString.isEmpty()){
                winnerString.append(", ").append(s);
            }
        }

        return winnerString;
    }
}
