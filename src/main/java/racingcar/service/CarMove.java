package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class CarMove {
    public static int moveCheck(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4){
            return 1;
        }
        return 0;
    }
    public static void move(HashMap<String,Integer> car_list){
        for (Map.Entry<String, Integer> item : car_list.entrySet()) {
            item.setValue(item.getValue() + moveCheck());

        }
    }
}
