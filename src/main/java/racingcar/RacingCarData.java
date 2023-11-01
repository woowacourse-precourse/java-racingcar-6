package racingcar;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class RacingCarData {
    // 입력한 자동차 이름을 쉼표를 기준으로 나누어 해시테이블에 담는 separateRacingCar 메서드
    public LinkedHashMap<String, Integer> separateRacingCar(String racingCarNames){
        LinkedHashMap<String, Integer> racingCarMap = new LinkedHashMap<>(); // 순서를 보장하기 위해 LinkedHashMap 타입 해시테이블 생성
        String[] splitCarNames = racingCarNames.split(","); // 입력값을 쉼표를 기준으로 String 배열에 담는다

        Set<String> carNameSet = new HashSet<>(); // 중복되는 이름이 존재하는지 확인하기 위해 Set 생성
        for (String carName : splitCarNames) { // 중복되는 이름이 존재하면 예외 발생
            if (!carNameSet.add(carName)) {
                throw new IllegalArgumentException();
            }
        }

        for(String CarName : splitCarNames){ // String 배열에 담는 자동차 이름을 순서대로 해시테이블에 담는다
            if(CarName.equals("")){ // 자동차 이름이 없다면 예외 발생
                throw new IllegalArgumentException();
            }
            racingCarMap.put(CarName, 0); // Key는 자동차 이름이고 Value는 0으로 초기화
        }
        return racingCarMap;
    }

    // 랜덤 생성 숫자가 4를 넘는지 확인하는 updateRacingCarDistance 메서드
    public int updateRacingCarDistance(int randomUpdateNumber){
        if(randomUpdateNumber >= 4){ // 4 이상이면 return 1
            return 1;
        }
        else{ // 그렇지 않으면 return 0
            return 0;
        }
    }
}
