package ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = splitByComma(input);
        validateCarNames(carNames);
        return carNames;
    }

    public static int inputNumberOfTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }
}