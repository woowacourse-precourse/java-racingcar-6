package racingcar.game.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.game.constant.StringConstants;

public class Input {
    public static String promptLine(String message) {
        Output.println(message);
        return Console.readLine();
    }

    public static List<String> inputPlayers() throws PlayerNameFormatException {
        String input = promptLine(StringConstants.PLAYER_PROMPT_MESSAGE);
        var userNames = Arrays.stream(input.split(",")).toList();
        var containsInvalidName = userNames.stream().anyMatch(n -> n.length() > 5);
        if (containsInvalidName) {
            throw new PlayerNameFormatException();
        }
        return userNames;
    }

    public static int inputGamePhase() throws NumberFormatException {
        String input = promptLine(StringConstants.TRY_COUNT_PROMPT_MESSAGE);
        return Integer.parseInt(input);
    }

    private static class PlayerNameFormatException extends IllegalArgumentException {
    }
}
