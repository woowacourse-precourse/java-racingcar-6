package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Validator.NumberValidator;
import racingcar.Validator.StringValidator;

public class InputView {
    // 경주할 자동차 입력 받음
    private final static String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static List<String> readCarNames() {
        System.out.println(CAR_INPUT_MESSAGE);
        String input = Console.readLine();

        String[] carNames = input.split(",");
        List<String> carNamesList = new ArrayList<>();

        for (String carName : carNames) {
            StringValidator.validateCarNameLength(carName);
            carNamesList.add(carName);
        }
        return carNamesList;
    }

    //시도 횟수 입력 받음
    public static int readNumberAttempts()
    {
        System.out.println(TRY_INPUT_MESSAGE);
        String input = Console.readLine();
        NumberValidator.validateIsNumberic(input);
        NumberValidator.validateIsNumberInRange(input);
        return Integer.parseInt(input);
    }
}

