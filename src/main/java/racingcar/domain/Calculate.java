package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Calculate {
    public HashMap<String,Integer> MappingNameAndCar(List<String> carNames){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<carNames.size(); i++){
            map.put(carNames.get(i),0);
        }

        return map;
    }

    public HashMap<String, Integer> setCarPosition(HashMap<String,Integer> Racers){
        int number;
        for (String key : Racers.keySet()) {
            number = Randoms.pickNumberInRange(0,9);
            if(number>=4){
                int tmp = Racers.get(key);
                tmp++;
                Racers.replace(key,tmp);
            }
        }
        return Racers;
    }

    //test용 overloading 함수, 랜덤기능을 제외하고 모든 user를 전진시킨다.
    public HashMap<String, Integer> setCarPosition(){
        int number;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {{
            put("pobi", 0);
            put("woni", 0);
            put("jun", 0);
        }};

        for (String key : hashMap.keySet()) {
            int tmp = hashMap.get(key);
            tmp++;
            hashMap.replace(key,tmp);
        }
        return hashMap;
    }
}
