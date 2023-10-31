package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    static String STRING_INPUT_CARNAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static String STRING_INPUT_ATTEMPCOUNT = "시도할 회수는 몇회인가요?";

    public List<String> inputNames() {
        System.out.println(STRING_INPUT_CARNAMES);
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split("[,]"));
        return names;
    }

    public int inputAttempCount() {
        System.out.println(STRING_INPUT_ATTEMPCOUNT);
        int input = Integer.parseInt(Console.readLine());
        return input;
    }
}
