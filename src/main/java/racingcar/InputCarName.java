package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;

public class InputCarName {
    public void inputCarName(HashMap<String, Integer> carName) {
        System.out.println("경주할 자동차 이름을 입력하세요.");

        String carNames = Console.readLine();
        List<String> carNameList = List.of(carNames.split(","));

        for (int i  = 0; i < carNameList.size(); i++) {
            carName.put(carNameList.get(i),0);
        }
    }
}
