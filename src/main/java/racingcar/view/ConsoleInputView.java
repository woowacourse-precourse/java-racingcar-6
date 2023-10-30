package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {
    private final static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private final static String ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> getCarNamesInput() {
        displayMessage(START_MESSAGE);
        return namesToList(Console.readLine());
    }

    public String getRoundInput() {
        displayMessage(ROUND_MESSAGE);
        return Console.readLine();
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }

    private List<String> namesToList(String names) {
        return Arrays.asList(names.split("\\s*,\\s*"));
    }
}
