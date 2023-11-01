package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.InputValidator;

public class InputView {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public static int getRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        InputValidator.verifyRounds(input);
        Console.close();
        return Integer.parseInt(input);
    }
}
