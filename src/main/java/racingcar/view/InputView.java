package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validation.InputValidation;


public class InputView {

    private static final String ASK_TRIES="시도할 회수는 몇회인가요?";

    public String readTriesInput(){
        System.out.println(ASK_TRIES);
        return Console.readLine();
    }

}
