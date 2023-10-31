package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private final NameListValidator nameListValidator;

    InputView() {
        this.nameListValidator = new NameListValidator();
    }

    public List<String> getNameList(){
        String userInput = Console.readLine();
        return nameListValidator.validate(userInput);
    }
}
