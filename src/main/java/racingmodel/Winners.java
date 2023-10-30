package racingmodel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Winners {

    private Winners() {
    }

    public static List<String> getWinner(LinkedHashMap<String, StringBuilder> carName) {
        return judgeWinner(carName);
    }

    private static List<String> judgeWinner(LinkedHashMap<String, StringBuilder> carName) {
        List<String> winners = new ArrayList<>();
        int maxScore = 0;
        for (Map.Entry<String, StringBuilder> entry : carName.entrySet()) {
            changeWinner(winners, entry.getKey(), entry.getValue().length(), maxScore);
        }
        return winners;
    }

    private static void changeWinner(List<String> winners, String player, int length, int maxScore) {
        SaveWinner winnerStatus = judgeNewOrAddOtNot(length, maxScore);

        if (winnerStatus == SaveWinner.ADD_WINNER) {
            winners.add(player);
        } else if (winnerStatus == SaveWinner.NEW_WINNER) {
            winners.clear();
            winners.add(player);
        }
    }

    private static SaveWinner judgeNewOrAddOtNot(int length, int maxScore) {
        if (length > maxScore) {
            return SaveWinner.NEW_WINNER;
        } else if (length == maxScore) {
            return SaveWinner.ADD_WINNER;
        }
        return SaveWinner.NOT;
    }
}
