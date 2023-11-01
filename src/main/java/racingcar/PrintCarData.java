package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PrintCarData {
    // 자동차의 이동거리를 리턴하는 printRacingCarDistance 메서드
    public String printRacingCarDistance(int racingCarNameValue){
        StringBuilder carDistance = new StringBuilder();
        for(int i=0; i < racingCarNameValue; i++){ // 이동거리만큼 -를 저장
            carDistance.append("-");
        }
        return carDistance.toString();
    }

    // 최종 우승자를 리턴하는 printWinRacingCar 메서드
    public String printWinRacingCar(LinkedHashMap<String, Integer> racingCarNames, int tryNumber){
        ArrayList<String> winRacingCarsArray = new ArrayList<>(); // 우승 자동차를 담기 위해 winRacingCarsArray 배열 생성
        for(String racingCarName : racingCarNames.keySet()){
            if(racingCarNames.get(racingCarName) == tryNumber){ // 이동거리 == 시도한 회수 인 자동차이면
                winRacingCarsArray.add(racingCarName); // 배열에 담는다
            }
        }
        return String.join(", ", winRacingCarsArray); // join 메서드를 통해 배열에 존재하는 자동차를 출력
    }
}
