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
            nameLengthCheck(car);
            carList.add(car);
        }
        return carList;
    }

    private void nameLengthCheck(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자이하이고 여러개라면 쉽표(,)로 구분해야 합니다.");
        }
    }

}
