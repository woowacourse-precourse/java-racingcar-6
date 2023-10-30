package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidation;

import java.util.HashMap;
import java.util.List;

public class InputUtil {
    private InputValidation validatior = new InputValidation();
    public void inputCarName(HashMap<String, Integer> carName) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();
        List<String> carNameList = List.of(carNames.split(","));

        for (int i  = 0; i < carNameList.size(); i++) {
            carName.put(carNameList.get(i),0);
        }
        validatior.inputCarNameDuplication(carName, carNameList);
    }

    public long inputMovement() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Long.parseLong(Console.readLine());
    }
}
