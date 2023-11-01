package racingcar.player;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ErrorMessage;

public class Player {
    public String[] inputCarNames() {
        String inputValue = Console.readLine();
        return parseCarNamesFromInput(inputValue);
    }

    private String[] parseCarNamesFromInput(String inputValue) {
        final String separator = ",";
        String[] result = inputValue.split(separator);
        if (result.length == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAMES.getMessage());
        }
        return result;
    }

    public String inputMoveCnt() {
        return Console.readLine();
    }
}
