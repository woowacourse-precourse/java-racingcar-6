package racingcar.Game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.View.UserInput;

public class Controller {

    private final int INITIAL_SCORE = 0;
    private final int MOVE_DECIDE_NUMBER = 4;
    private final int MAX_MOVE_NUMBER = 9;
    private final int MIN_MOVE_NUMBER = 0;


    public HashMap<String, Integer> createScoreBoard() {
        UserInput userInput = new UserInput();
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        for (String carName : userInput.carName()) {
            scoreBoard.put(carName, INITIAL_SCORE);
        }
        return scoreBoard;
    }

    public HashMap<String, Integer> carMove(HashMap<String, Integer> scoreBoard) {
        for (Map.Entry<String, Integer> score : scoreBoard.entrySet()) {
            score.setValue(decideMove(score.getValue()));
        }
        return scoreBoard;
    }

    public int decideMove(int score) {
        int randomValue = Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER);
        if (randomValue >= MOVE_DECIDE_NUMBER) {
            score++;
        }
        return score;
    }

    public String findWinner(HashMap<String, Integer> scoreBoard) {
        List<String> winnerList = new ArrayList<>();

        int maxValue = Collections.max(scoreBoard.values());
        for (Map.Entry<String, Integer> entry : scoreBoard.entrySet()) {
            if (entry.getValue() == maxValue) {
                winnerList.add(entry.getKey());
            }
        }
        return String.join(",", winnerList);
    }
}