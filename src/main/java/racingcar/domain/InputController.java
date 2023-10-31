package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    public String insertCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = readLine();
        return carNames;
    }

    public List<String> setCar(String carNames) {
        List<String> carList = new ArrayList<>();
        for (String car : carNames.split(",")) {
            carList.add(car);
        }
        return carList;
    }
}
