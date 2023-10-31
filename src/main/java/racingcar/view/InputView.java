package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.enums.TextEnum;
import racingcar.validator.InputValidator;

public class InputView {

    InputValidator inputValidator = new InputValidator();

    public ArrayList<String> getParticipant() {
        System.out.println(TextEnum.PARTICIPANT_TEXT);

        return inputValidator
                .validateParticipant(Console.readLine());

    }

    public int getTryCount() {
        System.out.println(TextEnum.ROUND_TEXT);

        return inputValidator
                .validateCount(Console.readLine());
    }
}
