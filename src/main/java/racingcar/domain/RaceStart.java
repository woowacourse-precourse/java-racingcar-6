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

    public static void showResult(Map<String, Integer> car){
        //실행 결과 보여주기
        for(String s : car.keySet()){
            System.out.print(s + " : ");
            for(int i = 0; i < car.get(s); i++){
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
