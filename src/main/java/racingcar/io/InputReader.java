package racingcar.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.validation.CarNameValidator;
import racingcar.validation.Triesvalidator;

public class InputReader {
    private int userInputCount;
    private List<String> carNames;

    public void readUserInputCount() {
        String input = readLine();
        Triesvalidator.validate(input);
        this.userInputCount = Integer.parseInt(input);
    }

    public void readCarNames() {
        String input = readLine();
        this.carNames = Arrays.asList(input.split(","));
        for (String name : carNames) {
            CarNameValidator.validate(name.trim());
        }
    }

    public int getUserInputCount() {
        return userInputCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
