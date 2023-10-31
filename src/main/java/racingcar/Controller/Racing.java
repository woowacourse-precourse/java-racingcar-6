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
//            for(String car: carLists){
//                //addAccumulateGame(result,player);
//                String forwardValue = output.saveForward(output.canForward());
//                result.put(car, result.getOrDefault(car, "") + forwardValue);
//            }
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

    public void addAccumulateGame(Map<String,String> result, String car){
        Output output=new Output();
        if (result.containsKey(car)) {
            result.put(car, result.get(car) + output.saveForward(output.canForward()));
        } else {
            result.put(car, output.saveForward(output.canForward()));
        }
    }
}
