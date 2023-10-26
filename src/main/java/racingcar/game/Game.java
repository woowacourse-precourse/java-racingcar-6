package racingcar.game;

import java.util.HashMap;
import java.util.List;

import racingcar.input.PlayNumber;
import racingcar.input.PlayerName;
import racingcar.random.DriveStop;
import racingcar.view.PlayGameMsg;
import racingcar.view.RequestInput;

import java.util.Map;

public class Game {

    private int playNum;
    public Map<String, Integer> playerScore = new HashMap<String, Integer>();
    public RequestInput requestInput = new RequestInput();
    public PlayerName playerName = new PlayerName();
    public PlayNumber playNumber = new PlayNumber();
    public PlayGameMsg playGameMsg = new PlayGameMsg();
    public DriveStop driveStop = new DriveStop();

    public void setGame(){
        setPlayer();
        setPlayNum();
    }

    public void playGame(){
        playGameMsg.start();
    }

    public void setPlayer(){
        requestInput.playerName();
        List<String> playerNames = playerName.validatedUserInput();
        for(String playerName: playerNames) {
            playerScore.put(playerName, 0);
        }
    }

    public void setPlayNum(){
        requestInput.playNum();
        playNum = playNumber.validatedUserInput();
    }
}
