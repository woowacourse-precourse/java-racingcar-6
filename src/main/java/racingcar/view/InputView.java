package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {
    public List<String> getCarNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNameList = Arrays.asList(input.split(","));
        InputValidator.verifyCarNames(carNameList);
        return carNameList;
    }

    public int getRoundTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
