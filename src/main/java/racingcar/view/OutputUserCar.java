package racingcar.view;

import java.util.Iterator;
import java.util.Map;

public class OutputUserCar {
    private static final String resultComment = "실행결과";

    public void printResultComment(){
        System.out.println(resultComment);
    }
    public void racingCurrent(Map<String, Integer> currentSituation){
        Iterator<String> iterator = currentSituation.keySet().iterator();
        while(iterator.hasNext()){
            String keyValue = iterator.next();
            printPersonalResultComment(keyValue, currentSituation.get(keyValue));
        }
        System.out.println();
    }

    public void printPersonalResultComment(String carName, int scoreValue){
        System.out.println(carName+" : "+scoreValue);
    }
}
