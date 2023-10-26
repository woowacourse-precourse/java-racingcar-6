package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.enums.TextEnum;
import racingcar.validator.InputValidator;

public class InputView {

    public static ArrayList<String> getParticipant() {
        System.out.println(TextEnum.PARTICIPANT_TEXT);

        return InputValidator
                .validateParticipant(Console.readLine());

    }

    public static int getTryCount() {
        System.out.println(TextEnum.ROUND_TEXT);

        return InputValidator
                .validateCount(Console.readLine());
    }
}
