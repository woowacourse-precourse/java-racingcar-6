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
            for(String car: carLists){
                //addAccumulateGame(result,player);
                String forwardValue = output.saveForward(output.canForward());
                result.put(car, result.getOrDefault(car, "") + forwardValue);
            }
            output.printRaceRound(result);

        }
        return result;
    }
    public void addAccumulateGame(Map<String,String> result, String car){
        Output output=new Output();
        if (result.containsKey(car)) {
            result.put(car, result.get(car) + output.saveForward(output.canForward()));
        } else {
            result.put(car, output.saveForward(output.canForward()));
        }
    }
}
