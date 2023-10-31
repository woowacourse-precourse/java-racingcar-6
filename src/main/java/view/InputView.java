package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private final NameListValidator nameListValidator;
    private final AttemptTimesValidator attemptTimesValidator;

    InputView(AttemptTimesValidator attemptTimesValidator) {
        this.attemptTimesValidator = attemptTimesValidator;
        this.nameListValidator = new NameListValidator();
    }

    public List<String> getNameList(){
        String userInput = Console.readLine();
        nameListValidator.validate(userInput);
        return nameListValidator.splitAndTrim(userInput, ",");
    }

    public int getAttemptTimes(){
        String userInput = Console.readLine();
        attemptTimesValidator.validate(userInput);
        return Integer.parseInt(userInput);
    }
}
