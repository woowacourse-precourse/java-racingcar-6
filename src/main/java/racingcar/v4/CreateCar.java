package racingcar.v4;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCar {
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        return inputCarNames;
    }

    public void validateCarNameNotEmpty(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
    }
    public List<String> splitCarNames(String inputCarNames) {
        List<String> carNamesList = new ArrayList<>(Arrays.asList(inputCarNames.split(",")));
        for (int i = 0; i < carNamesList.size(); i++) {
            carNamesList.set(i, carNamesList.get(i).trim());
        }
        return carNamesList;
    }

    public void validateCarNameLength(List carNamesList) {
        for (int i = 0; i < carNamesList.size(); i++) {
            if (carNamesList.get(i).toString().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

}
