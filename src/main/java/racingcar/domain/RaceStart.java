package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class RaceStart {
    public static void allowNumber(Map<String, Integer> car){
        //자동차에 무작위 값 할당하기
        for(String s : car.keySet()){
            int random = Randoms.pickNumberInRange(0, 9);
            if(random >= 4){
                car.put(s, car.get(s) + 1);
            }
        }
    }

    public static void forwardOrStop(){
        //4 이상일 경우 전진
    }
}
