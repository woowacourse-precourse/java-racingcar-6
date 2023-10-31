package racingcar.Game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.View.UserInput;

public class Controller {

    public HashMap<String, Integer> createScoreBoard(){
        UserInput userInput = new UserInput();
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        for (String carName : userInput.carName()) {
            scoreBoard.put(carName, 0);
        }
        return scoreBoard;
    }

    public HashMap<String, Integer> carMove(HashMap<String, Integer> scoreBoard){
        for (Map.Entry<String,Integer> score : scoreBoard.entrySet()){
            score.setValue(decideMove(score.getValue()));
        }
        return scoreBoard;
    }

    public int decideMove (int score) {
        int randomValue = Randoms.pickNumberInRange(0,9);
        if (randomValue >= 4) {
            score++;
        }
        return score;
    }

    public String findWinner (HashMap<String, Integer> scoreBoard) {
        List<String> winnerList = new ArrayList<>();

        int maxValue = Collections.max(scoreBoard.values());
        for (Map.Entry<String, Integer> entry : scoreBoard.entrySet()) {
            if (entry.getValue() == maxValue) {
                winnerList.add(entry.getKey());
            }
        }
        return String.join(",",winnerList);
    }
}