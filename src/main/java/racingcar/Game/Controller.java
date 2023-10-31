package racingcar.Game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {

    public List<Integer> SetScoreBoard(List<String> carName) {
        List<Integer> scoreBoard = new ArrayList<>(carName.size());
        for (int i = 0; i < carName.size(); i++) {
            scoreBoard.add(0);
        }
        return scoreBoard;
    }

    public List<Integer> CarMove(List<Integer> scoreBoard) {

        // iterator 사용가능?
        for(int i = 0; i < scoreBoard.size(); i++) {
            int MoveValue = Randoms.pickNumberInRange(0, 9);
            System.out.println(MoveValue);
            if (MoveValue >= 4) {
                int j = scoreBoard.get(i);
                scoreBoard.set(i, j + 1);
                System.out.println(scoreBoard.get(i));
            }
        }
        return scoreBoard;
    }

    public void PrintScore (List<String> carName, List<Integer> scoreBoard){

        List<String> moveProgress = new ArrayList<>();

        for (int i = 0; i < carName.size(); i++) {
            moveProgress.add(carName.get(i));
            moveProgress.add(" : ");
            for (int j = 0; j < scoreBoard.get(i); j++) {
                moveProgress.add("-");
            }
            System.out.println(String.join("",moveProgress));
        }
    }



    public String getWinner (List<String> carName, List<Integer> scoreBoard) {
        int maxScore = Collections.max(scoreBoard); // stream 프레임워크 쓸수 있는지?

        return carName.get(scoreBoard.indexOf(maxScore));
    }

}
