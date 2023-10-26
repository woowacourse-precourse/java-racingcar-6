package racingcar.game;

import java.util.HashMap;
import java.util.List;
import racingcar.input.PlayerName;
import racingcar.view.RequestInput;

import java.util.Map;

public class Game {

    public Map<String, Integer> playerScore = new HashMap<String, Integer>();

    public RequestInput requestInput = new RequestInput();
    public PlayerName playerName = new PlayerName();

    public void setGame(){
        setPlayer();
    }

    public void setPlayer(){
        requestInput.playerName();
        List<String> playerNames = playerName.validatedUserInput();
        for(String playerName: playerNames) {
            playerScore.put(playerName, 0);
        }
    }
}
