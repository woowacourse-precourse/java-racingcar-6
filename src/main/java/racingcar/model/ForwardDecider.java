package racingcar.model;

import java.util.Map;

public class ForwardDecider {

    public static Map<String,String> decideForward(Map<String,String> NameWithString,Map<String,Integer> NameWithRandomNumber) {
        for (String key : NameWithRandomNumber.keySet()){
            if(NameWithRandomNumber.get(key) >= 4){
                String currentValue = NameWithString.get(key);
                NameWithString.put(key,currentValue+"-");
            }
        }
        return NameWithString;
    }
}

