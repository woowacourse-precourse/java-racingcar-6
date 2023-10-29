package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void tryGame(List<String> members, int TryNumber) {
        MoveChecker moveChecker = new MoveChecker();
        WinnerChecker winnerChecker = new WinnerChecker();
        System.out.println();
        System.out.println("실행 결과");
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < members.size(); i++)
            count.add(0);
        for (int i = 0; i < TryNumber; i++) {
            count = moveChecker.checkMoveOrStop(members, count);
            System.out.println();
        }
        winnerChecker.checkWinner(members, count);
    }
}
