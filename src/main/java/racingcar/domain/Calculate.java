package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Calculate {
    public HashMap<String,Integer> MappingNameAndCar(String carNames){
        //쉼표로 구분
        List<String> list = Arrays.asList(carNames.split(","));
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<list.size(); i++){
            map.put(list.get(i),0);
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
}
