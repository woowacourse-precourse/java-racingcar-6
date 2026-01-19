package racingcar.domain;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class ReadRacingResult {

    public String readHashMap(LinkedHashMap<Map.Entry<Integer, String>, Integer> racingResult) {
        StringBuilder result = new StringBuilder();
        //Map.Entry<Map.Entry<Integer, String>, Integer> 형태로 {(인덱스, 차이름) : 이동값} 형태의 해시맵 제작 
        //차이름의 중복을 허용하기 위해 위와같은 형태로 제작 
        for (Map.Entry<Map.Entry<Integer, String>, Integer> racingRecord : racingResult.entrySet()) {
            result.append(racingRecord.getKey().getValue()).append(" : ").append("-".repeat(racingRecord.getValue()));
            result.append("\n");
        }
        String output = result.toString();
        System.out.println(output);

        return output;

    }

    public List<String> winners = new ArrayList<>();

    public String judgmentWinner(LinkedHashMap<Map.Entry<Integer, String>, Integer> racingResult) {
        int maxRecord = Collections.max(racingResult.values());
        //가장 먼거리로 이동한 자동차들을 찾음
        for (Map.Entry<Map.Entry<Integer, String>, Integer> racingRecord : racingResult.entrySet()) {
            findWinner(maxRecord, racingRecord);
        }
        String result = String.format("최종 우승자 : %s", String.join(", ", winners));
        System.out.println(result);
        return result;
    }

    private void findWinner(int maxRecord, Map.Entry<Map.Entry<Integer, String>, Integer> currentCarRecord) {
        //자동차의 이동거리가 가장 멀리 이동한 거리(maxRecord) 인지 비교
        if (currentCarRecord.getValue() >= maxRecord) {
            winners.add(currentCarRecord.getKey().getValue());
        }
    }


}
