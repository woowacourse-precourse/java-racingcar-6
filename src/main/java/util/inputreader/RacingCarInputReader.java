package util.inputreader;

import static racingcar.Constants.BLANK;
import static racingcar.Constants.COMMA;
import static racingcar.Constants.MIN_TRY_COUNT;
import static racingcar.Constants.PLAYER_NAME_MAX_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCarInputReader implements InputReader {
    public String readPlayers() throws IllegalArgumentException{
        String players =  this.readStringInput();
        if(!isValidPlayers(players)){
            throw new IllegalArgumentException("Invalid player names");
        }
        return players;
    }

    public boolean isValidPlayers(String players) {
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

    public int readTryCount() throws IllegalArgumentException{
        int tryCount = this.readIntInput();
        if(!isValidTryCount(tryCount)){
            throw new IllegalArgumentException("Invalid try count");
        }
        return tryCount;
    }

    public boolean isValidTryCount(int tryCount){
        return tryCount >= MIN_TRY_COUNT;
    }
}
