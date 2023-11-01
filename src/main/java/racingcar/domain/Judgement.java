package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Judgement {
    private int THE_FIRST_DISTANCE = 0;
    public List<String> compareDistance(Map<String,String> users, List<String> names){
        List<String> winner = new ArrayList<>();
        for(int index = 0; index < users.size();index++){
            if(THE_FIRST_DISTANCE <= users.get(names.get(index)).length()){
                THE_FIRST_DISTANCE = users.get(names.get(index)).length();
            }
        }
        for(int index = 0; index < users.size();index++){
            if(THE_FIRST_DISTANCE == users.get(names.get(index)).length()){
                winner.add(names.get(index));
            }
        }
        return winner;

    }
}
