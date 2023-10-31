package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import validator.AttemptTimesValidator;
import validator.NameListValidator;

public class InputView {
    public String getUserInput(){
        return Console.readLine();
    }
}
