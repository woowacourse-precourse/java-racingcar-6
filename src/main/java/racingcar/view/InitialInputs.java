package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.validation.CarNames;
import racingcar.validation.ExecutionNumber;

public class InitialInputs {
    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        CarNames checkCarNames = new CarNames();
        return checkCarNames.validateCarNames(input);
    }

    public static int readExcecutionNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        ExecutionNumber checkExecutionNumber = new ExecutionNumber();
        return checkExecutionNumber.validateExcutionNumber(input);
    }

}
