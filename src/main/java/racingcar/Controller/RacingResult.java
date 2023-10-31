package racingcar.Controller;

import static racingcar.Controller.WinnerController.outputView;

import java.util.HashMap;
import java.util.Map;

public class RacingResult {
    //실행결과 출력
    public static void printRacingResult(Map<String,Integer> map){
        boolean allValuesAreZero = areAllValuesZero(map);

        if (allValuesAreZero) {
            throw new IllegalArgumentException("아무런 자동차도 전진하지 못했습니다.");
        }else {
            int maxValue = Integer.MIN_VALUE;

            // 최대 값을 가지고 있는 key 초기화
            String maxKeys = "";

            // Map을 순회하며 최대 값을 찾음
            for (String carName : map.keySet()) {
                int value = map.get(carName);
                Map<String, Integer> carResultNumber = new HashMap<>();
                carResultNumber.put(carName,value);
                String resultBar = outputView.printRandomCount(value);

                Map<String, String> carResultBar = new HashMap<>();
                carResultBar.put(carName,resultBar);

                System.out.print( carName + " : " + carResultBar.get(carName) + ", ");


                if (value > maxValue) {
                    maxValue = value;
                    maxKeys = carName;
                } else if (value == maxValue) {
                    maxKeys += ", " +  carName;
                }

            }
            outputView.printWinnerName();
            System.out.println(maxKeys);
        }


    }
    public static <T> boolean areAllValuesZero(Map<T, Integer> map) {
        for (Integer value : map.values()) {
            if (value != 0) {
                return false; // 최소 하나의 value가 0이 아니라면 false 반환
            }
        }
        return true; // 모든 value가 0이면 true 반환
    }
}
