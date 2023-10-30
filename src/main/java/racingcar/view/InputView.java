package racingcar.view;

import static racingcar.view.RacingCarConsole.print;
import static racingcar.view.RacingCarConstants.ATTEMPTS_PROMPT;
import static racingcar.view.RacingCarConstants.CAR_NAME_DELIMITER;
import static racingcar.view.RacingCarConstants.CAR_NAME_PROMPT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.AttemptsNumber;
import racingcar.model.CarNames;

public class InputView {

    public CarNames readCarNames() {
        print(CAR_NAME_PROMPT);
        String[] splitCarNames = Console.readLine().split(CAR_NAME_DELIMITER);
        List<String> carNames = Arrays.stream(splitCarNames)
                .map(String::trim)
                .collect(Collectors.toList());
        return new CarNames(carNames);
    }

    public AttemptsNumber readAttemptsNumber() {
        print(ATTEMPTS_PROMPT);
        String attemptsNumber = Console.readLine();
        return new AttemptsNumber(attemptsNumber);
    }
}
