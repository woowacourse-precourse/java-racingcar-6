package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {
    private static final String RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT = "시도할 횟수는 몇회인가요?";

    public static String askCarName(){
        String name = Console.readLine();
        return name;
    }

    public static void printAskCarName(){
        System.out.println(RACING_CAR_NAME);
    }

    public static int askTryCount(){
        System.out.println(TRY_COUNT);
        String inputTryCount = Console.readLine();
        if (inputTryCount.matches(".*[a-zA-Z\\W]+.*")) {
            throw new IllegalArgumentException("문자 또는 특수문자는 허용되지 않습니다.");
        }
        int intTrtCount = Integer.parseInt(inputTryCount);
        return intTrtCount;
    }

    public static Map<String,Integer> storeCarName() {
        List<String> carName = Arrays.asList(askCarName().split(","));
        Map<String,Integer> carCountMap = new HashMap<String,Integer>();
        for(String car : carName){

            if(car.length() >5){
                throw new IllegalArgumentException("자동차의 이름은 5이하만 가능합니다.");
            }
            else{
                carCountMap.put(car,0);
            }
            carCountMap.put(car,0);
        }
        return carCountMap;
    }
}
