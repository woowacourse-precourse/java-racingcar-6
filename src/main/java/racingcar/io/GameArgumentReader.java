package racingcar.io;

import java.util.Arrays;
import java.util.List;
import racingcar.game.GameArgumentValidator;

public class GameArgumentReader {

    private final InputReader inputReader;

    public GameArgumentReader(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public List<String> readCarNames() {
        GameConsoleOutput.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = inputReader.readLine();
        List<String> carNames = Arrays.stream(carInput.split(",")).toList();
        GameArgumentValidator.validateCarNames(carNames);
        return carNames;
    }

    public String readAttemptNumber() {
        GameConsoleOutput.print("시도할 회수는 몇회인가요?");
        String attemptNumber = inputReader.readLine();
        GameArgumentValidator.validateAttemptInput(attemptNumber);
        return attemptNumber;
    }
}
