package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.verifier.AttemptsNumVerifier;
import racingcar.verifier.CarNameVerifier;
import racingcar.verifier.Verifier;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String ATTEMPTS_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";

    private final Verifier<String> carNameVerifier = new CarNameVerifier();

    private final Verifier<String> attemptsNumVerifier = new AttemptsNumVerifier();

    public List<String> readCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carNames = Console.readLine();
        carNameVerifier.validate(carNames);
        return Arrays.asList(carNames.split(","));
    }

    public Integer readAttempts() {
        System.out.println(ATTEMPTS_INPUT_MESSAGE);
        String attempts = Console.readLine();
        attemptsNumVerifier.validate(attempts);
        return Integer.parseInt(attempts);
    }


}
