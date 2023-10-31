package racingcar.race;

import java.util.ArrayList;
import java.util.List;

public class Compare {
    public static int saveMaxPosition(List<Integer> position) {
        int max = 0;
        for (int i = 0; i < position.size(); i++) {
            if (max < position.get(i)) {
                max = position.get(i);
            }
        }
        return max;
    }
    public static int findHowManyMax(List<Integer> position) {
        int max = saveMaxPosition(position);
        int count = 0;
        for (int i = 0; i < position.size(); i++) {
            if (position.get(i) == max) {
                count++;
            }
        }
        return count;
    }
    public static List<Integer> findMaxIndex(List<Integer> position) {
        int max = saveMaxPosition(position);
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < position.size(); i++) {
            if (position.get(i) == max) {
                index.add(i);
            }
        }
        return index;
    }
}
