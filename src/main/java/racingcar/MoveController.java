package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class MoveController {

    private int createRandomNumber() {
        return pickNumberInRange(0, 9);
    }

    public void tryMove(List<StringBuilder> moves) {
        for (StringBuilder move : moves) {
            moveCar(move);
        }
    }

    public void moveCar(StringBuilder mark) {
        int move = createRandomNumber();

        if (move < 4) {
            return;
        }

        mark.append('-');
    }

    private int findMaxMove(List<StringBuilder> moves) {
        int maxMove = 0;

        for (StringBuilder move : moves) {
            if (move.length() > maxMove) {
                maxMove = move.length();
            }
        }

        return maxMove;
    }

    public List<String> findWinner(List<String> cars, List<StringBuilder> moves) {
        int maxMove = findMaxMove(moves);
        List<String> winners = new ArrayList<>();

        for (int car = 0; car < cars.size(); car++) {
            if (moves.get(car).length() == maxMove) {
                winners.add(cars.get(car));
            }
        }

        return winners;
    }
}
