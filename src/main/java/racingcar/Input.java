package racingcar;

import java.util.Arrays;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputData = Console.readLine();
        Validator.checkCarInput(inputData);
        String[] splitInputData = inputData.split(",");
        return Arrays.asList(splitInputData);
    }
    public int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputData = Console.readLine();
        Validator.checkRoundInput(inputData);
        return Integer.parseInt(inputData);
    }
}
