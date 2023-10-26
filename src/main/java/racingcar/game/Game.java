package racingcar.game;

import java.util.*;

import racingcar.input.PlayNumber;
import racingcar.input.PlayerName;
import racingcar.random.DriveStop;
import racingcar.view.PlayGameMsg;
import racingcar.view.RequestInput;

public class Game {

    private int playNum;
    List<String> playerNames;
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
        repeatPlayNum();
    }

    public void endGame(){
        printFinalResult();
    }

    public void setPlayer(){
        requestInput.playerName();
        playerNames = playerName.validatedUserInput();
        for(String playerName: playerNames) {
            playerScore.put(playerName, 0);
        }
    }

    public void setPlayNum(){
        requestInput.playNum();
        playNum = playNumber.validatedUserInput();
    }

    public void repeatPlayNum(){
        for(int i=0; i<playNum; i++){
            repeatPlayers();
        }
    }

    public void repeatPlayers(){
        for(String player: playerNames){
            updateScore(player);
        }
        playGameMsg.changeLine();
    }

    public void updateScore(String player) {
        int score = playerScore.get(player);
        if (driveStop.isDrive()) {
            playerScore.replace(player, score + 1);
        }
        playGameMsg.eachResult(player, playerScore.get(player));
    }

    public void printFinalResult(){
        int maxScore = Collections.max(playerScore.values());
        List<String> winners = new ArrayList<String>();
        for(String player : playerNames){
            winners = addWinner(winners, player, maxScore);
        }
        String result = String.join(", ", winners);
        playGameMsg.end(result);
    }

    public List<String> addWinner(List<String> winners, String player, int maxScore){
        if(playerScore.get(player) == maxScore){
            winners.add(player);
        }
        return winners;
    }

}
