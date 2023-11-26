package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.verifier.AttemptsNumVerifier.ATTEMPTS_NUM_VERIFIER;
import static racingcar.verifier.CarNameVerifier.CAR_NAME_VERIFIER;

public final class InputView {

    public static final InputView INPUT_VIEW = new InputView();
    private final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ATTEMPTS_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";

    private InputView() {

    }

    public List<String> readCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carNames = Console.readLine();
        CAR_NAME_VERIFIER.validate(carNames);
        return Arrays.asList(carNames.split(","));
    }

    public Integer readAttempts() {
        System.out.println(ATTEMPTS_INPUT_MESSAGE);
        String attempts = Console.readLine();
        ATTEMPTS_NUM_VERIFIER.validate(attempts);
        return Integer.parseInt(attempts);
    }

}
