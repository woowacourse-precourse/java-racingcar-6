package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.output.Output;


public class Input {

    private final Output output;

    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_COUNT_PROMPT = "시도할 회수는 몇회인가요?";

    public Input(Output output) {
        this.output = output;
    }

    public String requestCarNames() {
        return read(CAR_NAMES_PROMPT);
    }

    public String requestRoundCount() {
        return read(ROUND_COUNT_PROMPT);
    }

    private String read(String message) {
        output.message(message);
        return Console.readLine();
    }
}
