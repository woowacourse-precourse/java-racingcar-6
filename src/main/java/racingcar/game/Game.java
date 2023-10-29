package racingcar.game;

import java.util.*;

import racingcar.input.NumberOfPlay;
import racingcar.input.CarName;
import racingcar.random.DriveStop;
import racingcar.view.PlayGameMsg;
import racingcar.view.RequestInput;

public class Game {

    private int playCount;
    private List<String> carNames;
    public Map<String, Integer> carNameScores = new HashMap<String, Integer>();
    public RequestInput requestInput = new RequestInput();
    public CarName carName = new CarName();
    public NumberOfPlay numberOfPlay = new NumberOfPlay();
    public PlayGameMsg playGameMsg = new PlayGameMsg();
    public DriveStop driveStop = new DriveStop();

    public void setGame(){
        setCar();
        setPlayCount();
    }

    public void playGame(){
        playGameMsg.start();
        repeatPlayCount();
    }

    public void endGame(){
        printFinalResult();
    }

    public void setCar(){
        requestInput.carName();
        carNames = carName.validatedUserInput();
        for(String playerName: carNames) {
            carNameScores.put(playerName, 0);
        }
    }

    public void setPlayCount(){
        requestInput.playCount();
        playCount = numberOfPlay.validatedUserInput();
    }

    public void repeatPlayCount(){
        for(int i = 0; i< playCount; i++){
            repeatCars();
        }
    }

    public void repeatCars(){
        for(String carName: carNames){
            updateScore(carName);
        }
        playGameMsg.changeLine();
    }

    public void updateScore(String carName) {
        int score = carNameScores.get(carName);
        if (driveStop.isDrive()) {
            carNameScores.replace(carName, score + 1);
        }
        playGameMsg.eachResult(carName, carNameScores.get(carName));
    }

    public void printFinalResult(){
        String result = finalWinners();
        playGameMsg.end(result);
    }

    public String finalWinners(){
        int maxScore = Collections.max(carNameScores.values());
        List<String> winners = new ArrayList<String>();
        for(String player : carNames) {
            winners = addWinner(winners, player, maxScore);
        }
        return String.join(", ", winners);
    }

    public List<String> addWinner(List<String> winners, String player, int maxScore){
        if(carNameScores.get(player) == maxScore){
            winners.add(player);
        }
        return winners;
    }

}
