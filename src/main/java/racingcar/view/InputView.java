package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private InputView() {
    }

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .toList();
    }

    public static String inputRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine()
                .trim();
    }
}
