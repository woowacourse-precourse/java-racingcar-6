package racingcar.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    final String NAME_INPUT_TEXT =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String TRIAL_INPUT_TEXT = "시도할 회수는 몇회인가요?";

    public InputHandler() {
    }

    public List<String> inputName() {
        System.out.println(NAME_INPUT_TEXT);
        String namesString = Console.readLine();
        return List.of(namesString.split(","));
    }

    public int inputTrial() {
        System.out.println(TRIAL_INPUT_TEXT);
        String trialString = Console.readLine();
        return Integer.parseInt(trialString);
    }
}
