package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String SEPARATOR = ",";
    private InputView() {}

    public static List<String> setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(SEPARATOR));

        return carNames;
    }

    public static String setAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
