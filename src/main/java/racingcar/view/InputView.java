package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String  CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT = "시도할 회수는 몇회인가요?";

    public void printCarNameMessage() {
        System.out.println(CAR_NAME_INPUT);
    }

    public void printTimesInputMessage() {
        System.out.println(RACE_COUNT);
    }

    public List<String> inputCarNames() {
        String carNames = Console.readLine();
        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();
        Validator.InputCarName(carNameList);
        return carNameList;
    }

    public Integer inputNumber() {
        String num = Console.readLine();
        Validator.InputRaceCount(num);
        return Integer.valueOf(num);
    }

}
