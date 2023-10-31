package racingcar;

import java.util.LinkedHashMap;

public class RacingCarData {
    // 입력한 자동차 이름을 쉼표를 기준으로 나누어 해시테이블에 담는 separateRacingCar 메서드
    public LinkedHashMap<String, Integer> separateRacingCar(String racingCarNames){
        LinkedHashMap<String, Integer> racingCarMap = new LinkedHashMap<>(); // 순서를 보장하기 위해 LinkedHashMap 타입 해시테이블 생성
        String[] splitCarNames = racingCarNames.split(","); // 입력값을 쉼표를 기준으로 String 배열에 담는다
        for(String CarName : splitCarNames){ // String 배열에 담는 자동차 이름을 순서대로 해시테이블에 담는다
            racingCarMap.put(CarName, 0); // Key는 자동차 이름이고 Value는 0으로 초기화
        }
        return racingCarMap;
    }
}
