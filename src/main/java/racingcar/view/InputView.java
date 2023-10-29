package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.model.dto.GameInput;

public class InputView {

    public static GameInput getInput() {
        List<String> names = getNames();
        Long totalTurns = getTotalTurns();

        return new GameInput(names, totalTurns);
    }

    private static List<String> getNames() {

        Messages.CAR_NAME_INPUT_ANNOUNCEMENT.print();
        String input = readLine();
        String[] names = input.split(",");
        List<String> namesList = List.of(names);
        if (!Validation.names(namesList))
            throw new IllegalArgumentException(Messages.ILLEGAL_NAME_ANNOUNCEMENT.getMessage());
        return namesList;
    }

    private static Long getTotalTurns() {
        Messages.GAME_TURN_INPUT_ANNOUNCEMENT.print();
        String input = readLine();
        try {
            Long inputNum = Long.parseLong(input);
            if (inputNum <= 0)
                throw new IllegalArgumentException(Messages.ILLEGAL_NUMBER_RANGE_ANNOUNCEMENT.getMessage());
            return inputNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ILLEGAL_NUMBER_ANNOUNCEMENT.getMessage());
        }
    }
}
