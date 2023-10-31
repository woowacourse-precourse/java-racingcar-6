package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {

    //차 이름을 HashMap<차이름,전진횟수>에 넣기
    public static Map<String, Integer> setCarRacingRecord(List<String> carList){
        Map<String,Integer> carRacingRecord = new HashMap<String,Integer>();
        for(String carName : carList) {
            carRacingRecord.put(carName, 0);
        }
        return carRacingRecord;
    }

    //저장된 Map에서 최댓값을 가지는 차 이름 가져오기
    public static List<String> getWinner(Map<String, Integer> carRacingRecord, int maxRecord){
        List<String> winners = new ArrayList<>();
        for(String carName : carRacingRecord.keySet()) {
            if(carRacingRecord.get(carName)==maxRecord) {
                winners.add(carName);
            }
        }
        return winners;
    }
}
