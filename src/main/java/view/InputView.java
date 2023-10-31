package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private final NameListValidator nameListValidator;
    private final AttemptTimesValidator attemptTimesValidator;

    InputView() {
        this.attemptTimesValidator = new AttemptTimesValidator();
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
