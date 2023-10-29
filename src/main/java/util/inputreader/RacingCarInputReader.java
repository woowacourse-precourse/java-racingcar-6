package util.inputreader;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCarInputReader implements InputReader {
    public String inputPlayers() throws IllegalArgumentException{
        String players =  this.readStringInput();
        if(!isInputPlayerValid(players)){
            throw new IllegalArgumentException("Invalid player names");
        }
        return players;
    }

    public boolean isInputPlayerValid(String players) {
        List<String> playerList = List.of(players.split(","));
        if (playerList.isEmpty()) {
            return false;
        }
        return playerList.stream().allMatch(this::isValidPlayerName);
    }

    private boolean isValidPlayerName(String player) {
        return player.length() <= 5 &&
                !player.contains(" ") &&
                !player.contains(",") &&
                !player.isEmpty();
    }

    public int inputTryCount() throws IllegalArgumentException{
        int tryCount = this.readIntInput();
        if(!isInputTryCountValid(tryCount)){
            throw new IllegalArgumentException("Invalid try count");
        }
        return tryCount;
    }

    public boolean isInputTryCountValid(int tryCount){
        return tryCount > 0;
    }
}
