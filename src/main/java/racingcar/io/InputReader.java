package racingcar.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class InputReader {
    private int userInputCount;
    private List<String> carNames;

    public InputReader() {
        readCarNames();
        readUserInputCount();
    }

    private void readUserInputCount() {
        String input = readLine();
        this.userInputCount = Integer.parseInt(input);
    }

    private void readCarNames() {
        String input = readLine();
        this.carNames = Arrays.asList(input.split(","));
    }

    public int getUserInputCount() {
        return userInputCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
