package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMove {
    public static boolean moveCheck(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
    public static void move(HashMap<String,Integer> car_list){
        for (Map.Entry<String, Integer> item : car_list.entrySet()) {
            if (moveCheck()) {
                item.setValue(item.getValue() + 1);
            }
        }
    }
}
