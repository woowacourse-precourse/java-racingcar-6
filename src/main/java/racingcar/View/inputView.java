package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Validator.stringValidator;

public class inputView {
   // 경주할 자동차 입력 받음
    public List<String> enterCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] carNames = input.split(",");
        List<String> carNamesList = new ArrayList<>();

        for (String carName : carNames) {
            stringValidator.validateCarNameLength(carName);
            carNamesList.add(carName);
        }
        return carNamesList;
    }
}
