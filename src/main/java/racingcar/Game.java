package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.code.Message;
import racingcar.utils.InputUtils;
import racingcar.utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        PrintUtils.print(Message.GAME_START);
        List<String> carNameList = InputUtils.inputCarName();

        PrintUtils.print(Message.TRY_COUNT);
        int tryCount = InputUtils.inputTryCount();

        PrintUtils.print("");

        Map<String, String> result = new HashMap<>();
        List<String> winner = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < tryCount; i++) {
            for (String car : carNameList) {
                String moveRecord = moveCar(result, car);
                result.put(car, moveRecord);

                max = checkWinner(winner, max, car, moveRecord);
            }
            PrintUtils.print("");
        }

        PrintUtils.print("");
        PrintUtils.print("최종 우승자 : " + String.join(",", winner));
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
}
