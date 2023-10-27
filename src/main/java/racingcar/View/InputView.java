package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {
    private static final String racingCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryCount = "시도할 횟수는 몇회인가요?";

    public String askCarName(){
        System.out.println(racingCarName);
        return Console.readLine();
    }

    public int askTryCount(){
        System.out.println(tryCount);
        String inputTryCount = Console.readLine();
        int intTrtCount = Integer.parseInt(inputTryCount);
        return intTrtCount;
    }

    public Map<String,Integer> storeCarName() {
        List<String> carName = Arrays.asList(askCarName().split(","));
        Map<String,Integer> carCountMap = new HashMap<String,Integer>();
        for(String car : carName){
            carCountMap.put(car,0);
        }
        return carCountMap;
    }
}
