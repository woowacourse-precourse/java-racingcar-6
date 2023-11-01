package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        Map<String, Integer> carMap = new HashMap<>();
        List<String> carList = new ArrayList<>();
        for(String carName : carNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            carMap.put(carName, 0);
            carList.add(carName);
        }
    }
}
