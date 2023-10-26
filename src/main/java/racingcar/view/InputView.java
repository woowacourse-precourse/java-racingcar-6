package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.enums.StringEnum;
import racingcar.validator.InputValidator;

public class InputView {

    InputValidator inputValidator = new InputValidator();

    public ArrayList<String> getParticipant() {
        System.out.println(StringEnum.PARTICIPANT_STRING);

        return inputValidator
                .validateParticipant(Console.readLine());

    }

    public int getTryCount() {
        System.out.println(StringEnum.ROUND_STRING);

        return inputValidator
                .validateCount(Console.readLine());
    }
}
