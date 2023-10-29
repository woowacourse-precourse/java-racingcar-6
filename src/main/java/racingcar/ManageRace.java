package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManageRace {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private String inputCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    private List<String> stringToList(String carNames) {
        List<String> carNameList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            carNameList.add(carName);
        }
        return carNameList;
    }

    private void checkValidNames(List<String> carNameList) {
        Set<String> set = new HashSet(carNameList);
        if (carNameList.size() != set.size()) {
            throw new IllegalArgumentException();
        }
        for (String carName : set) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
