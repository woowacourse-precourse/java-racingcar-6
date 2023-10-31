package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.game.GameArgumentValidator;

public final class GameArgumentReader {

    public static List<String> readCarNames() {
        GameConsoleOutput.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        List<String> carNames = Arrays.stream(carInput.split(",")).toList();
        GameArgumentValidator.validateCarName(carNames);
        return carNames;
    }

    public static String readAttemptNumber() {
        GameConsoleOutput.print("시도할 회수는 몇회인가요?");
        String attemptNumber = Console.readLine();
        GameArgumentValidator.validateAttemptInput(attemptNumber);
        return attemptNumber;
    }
}
