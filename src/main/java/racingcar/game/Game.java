package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.InputUtils;
import racingcar.utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingcar.code.Message.*;

/**
 * Game
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
public class Game {
    public void play() {
        PrintUtils.print(GAME_START);
        List<String> carNameList = InputUtils.inputCarName();

        PrintUtils.print(TRY_COUNT);
        int tryCount = InputUtils.inputTryCount();

        PrintUtils.print("");

        PrintUtils.print(RESULT);

        List<String> winner = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < tryCount; i++) {
            max = playCarGame(carNameList, winner, max);
        }

        PrintUtils.print(WINNER.getDescription() + String.join(",", winner));
    }

    private int playCarGame(List<String> carNameList, List<String> winner, int max) {
        Map<String, String> result = new HashMap<>();
        for (String car : carNameList) {
            String moveRecord = moveCar(result, car);
            result.put(car, moveRecord);

            max = checkWinner(winner, max, car, moveRecord);
        }
        PrintUtils.print("");
        return max;
    }

    private String moveCar(Map<String, String> result, String car) {
        String move = "";
        if (result.containsKey(car)) {
            move = result.get(car);
        }

        int number = Randoms.pickNumberInRange(0, 9);

        if (number >= 4) {
            move = move + "-";
        }
        PrintUtils.print(car + " : " + move);
        return move;
    }

    private int checkWinner(List<String> winner, int max, String car, String moveRecord) {
        if (moveRecord.length() > max) {
            winner.clear();
            winner.add(car);
            max = moveRecord.length();
        } else if (moveRecord.length() == max) {
            winner.add(car);
        }
        return max;
    }
}
