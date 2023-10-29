package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Application {
    
    // 게임 진행을 위해 자동차의 위치를 저장할 HashMap 선언
    private static final HashMap<String, Integer> carState = new HashMap<>();

    // HashMap에 자동차 이름과 위치를 0으로 초기 상태 지정
    public static void initializeCarState(String[] carNames) {
        for (String name : carNames) {
            carState.put(name, 0);
        }
    }
    
    // 자동차 이름이 5글자가 넘는 경우 예외 처리로 프로그램 종료
    public static void checkCarNameLength(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현


        // 사용자로부터 자동차 이름 입력을 받는 부분
        String carNames = readLine();
        String[] carNameArr = carNames.split(",");

        // 사용자 입력 확인
        checkCarNameLength(carNameArr);

        // CarState에 초기화
        initializeCarState(carNameArr);
        
        for(String key : carState.keySet()) {
            int value = carState.get(key);
            System.out.println(key + " : " + value);
        }


    }
}
