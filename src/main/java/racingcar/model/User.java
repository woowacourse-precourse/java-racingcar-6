package racingcar.model;

import static java.util.Arrays.asList;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.utils.UserInputValidator;

public class User {

    private final String SEPERATE_NAME_CHAR = ",";

    private final UserInputValidator userInputValidator = new UserInputValidator();
    private List<String> carNames = new ArrayList<>();
    private int tryCount = 0;

    public void inputCarName() {
        String input = Console.readLine();
        List<String> carNames = asList(split(input));
        userInputValidator.validateCarNames(carNames);
        this.carNames = carNames;
    }

    public void inputTryCount() {
        String count = Console.readLine();
        userInputValidator.validateTryCount(count);
        this.tryCount = Integer.parseInt(count);
    }

    public String[] split(String input) {
        return input.split(SEPERATE_NAME_CHAR);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
