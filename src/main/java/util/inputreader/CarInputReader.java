package util.inputreader;

import static racingcar.Constants.BLANK;
import static racingcar.Constants.COMMA;
import static racingcar.Constants.MIN_TRY_COUNT;
import static racingcar.Constants.PLAYER_NAME_MAX_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CarInputReader {
    public String readPlayers() throws IllegalArgumentException {
        String players = Console.readLine();
        if (!isValidPlayers(players)) {
            throw new IllegalArgumentException("Invalid player names");
        }
        return players;
    }

    public boolean isValidPlayers(String players) {
        if (players.isEmpty() || players.charAt(players.length() - 1) == COMMA.charAt(0)) {
            return false;
        }
        List<String> playerList = List.of(players.split(COMMA));
        if (playerList.isEmpty()) {
            return false;
        }
        return playerList.stream().allMatch(this::isValidPlayerName);
    }

    private boolean isValidPlayerName(String player) {
        return player.length() <= PLAYER_NAME_MAX_LENGTH &&
                !player.contains(BLANK) &&
                !player.contains(COMMA) &&
                !player.isEmpty();
    }

    public int readTryCount() throws IllegalArgumentException {
        String tryCount = Console.readLine();
        try {
            int tryCountInt = Integer.parseInt(tryCount);
            if (!isTryCountValid(tryCountInt)) {
                throw new IllegalArgumentException("Invalid try count");
            }
            return tryCountInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid try count");
        }
    }

    private boolean isTryCountValid(int tryCount) {
        return tryCount >= MIN_TRY_COUNT;
    }
}
