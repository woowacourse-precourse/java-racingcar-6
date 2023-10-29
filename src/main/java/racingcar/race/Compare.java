package racingcar.race;

import java.util.List;

public class Compare {
    public int saveMaxPosition(List<Integer> position) {
        int max = 0;
        for (int i = 0; i < position.size(); i++) {
            if (max < position.get(i)) {
                max = position.get(i);
            }
        }
        return max;
    }
    public int findHowManyMax(List<Integer> position) {
        int max = saveMaxPosition(position);
        int count = 0;
        for (int i = 0; i < position.size(); i++) {
            if (position.get(i) == max) {
                count++;
            }
        }
        return count;
    }
}
