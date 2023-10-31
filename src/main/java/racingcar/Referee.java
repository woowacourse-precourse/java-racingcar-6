package racingcar;

import java.util.ArrayList;
import java.util.List;

/*
 * 심판
 */
public class Referee {

    public String findWinner(List<Integer> dis, List<String> cars) {
        List<String> winner = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < dis.size(); i++) {
            if (max < dis.get(i)) {
                winner.clear();
                winner.add(cars.get(i));
                max = dis.get(i);
            } else if (max == dis.get(i)) {
                winner.add(cars.get(i));
                max = dis.get(i);
            }
        }
        return String.join(", ", winner);
    }
}
