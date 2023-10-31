package racingcar.Controller;

import racingcar.View.Output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {
    public Map<String,String> saveRaceGame(int repeatTime, List<String> carLists) {
        Map<String,String> result=new HashMap<>();
        Output output=new Output();
        for(int i=0; i<repeatTime; i++){
            result=playGame(result,carLists);
            output.printRaceRound(result);
        }
        return result;
    }
    public Map<String,String> playGame(Map<String,String> result,List<String> carLists){
        Output output = new Output();
        for(String car:carLists){
            String forwardValue=output.saveForward(output.canForward());
            result.put(car,result.getOrDefault(car,"")+forwardValue);
        }
        return result;
    }
}
