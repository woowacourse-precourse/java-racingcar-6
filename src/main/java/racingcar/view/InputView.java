package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.model.dto.GameInput;

public class InputView {

    public GameInput getInput() {
        List<String> names = getNames();
        Long totalTurns = getTotalTurns();

        return new GameInput(names, totalTurns);
    }

    private List<String> getNames() {
        Messages.CAR_NAME_INPUT_ANNOUNCEMENT.print();
        String input = readLine();
        String[] names = input.split(",");
        List<String> namesList = List.of(names);
        //Validation
        return namesList;
    }

    private Long getTotalTurns() {
        Messages.GAME_TURN_INPUT_ANNOUNCEMENT.print();
        String input = readLine();
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ILLEGAL_INPUT_ANNOUNCEMENT.getMessage());
        }
    }
}
