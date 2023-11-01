package racingcar.util;

import java.util.ArrayList;
import java.util.List;

public class CheckWinner {
    public List<String> check(List<String> players, List<String>[] playerCurrent) {
        int max = 0;
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < players.size(); i++) {

            if (playerCurrent[i].size() == max) {
                result.add(", " + players.get(i));
            }
            else if (playerCurrent[i].size() > max) {
                max = playerCurrent[i].size();
                result.clear();
                result.add(players.get(i));
            }
        }
        return result;
    }
}