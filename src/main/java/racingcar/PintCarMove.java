package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class PintCarMove {
    static final int MIN_NUM = 0;
    static final int MAX_NUM = 9;
    public static Map<String, Integer> printRaceResult(Map<String, Integer> raceResult) {

        for(String name : raceResult.keySet()){
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            int value = raceResult.get(name);
            if(randomNumber >= 4){
                raceResult.put(name, value + 1);
            }
            System.out.println (name + " : " + "-".repeat(raceResult.get(name)));
        }

        return raceResult;
    }
}
