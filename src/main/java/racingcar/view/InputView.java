package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import racingcar.util.StringHandler;

public class InputView {

    private static final String SPLITTER = ",";

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return StringHandler.separatedStringToList(input, SPLITTER);
    }

    public int inputTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return StringHandler.stringToInt(input);
    }
}
