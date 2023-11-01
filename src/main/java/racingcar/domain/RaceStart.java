package racingcar.domain;

import java.util.Map;

public class RaceStart {
    public static void forwardDecision(Map<String, Integer> car, int random, String s){
        //자동차 전진
        if(random >= 4){
            car.put(s, car.get(s) + 1);
        }
    }

    public static void showResult(Map<String, Integer> car){
        //실행 결과 보여주기
        StringBuilder sbResult = new StringBuilder();
        for(String s : car.keySet()){
            sbResult.append(s).append(" : ");
            for(int i = 0; i < car.get(s); i++){
                sbResult.append("-");
            }
            sbResult.append("\n");
        }
        sbResult.append("\n");

        System.out.print(sbResult);
    }
}
