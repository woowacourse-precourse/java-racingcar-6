package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Score {

    Map<String, Integer> movingDistance = new LinkedHashMap<>();

    public Score(Map<String, Integer> movingDistance) {
        this.movingDistance = movingDistance;
    }

    public void printScore() {
        for (Entry<String, Integer> entrySet : movingDistance.entrySet()) {
            System.out.print(entrySet.getKey() + " : ");
            printStick(entrySet.getValue());
        }
        System.out.println();
    }

    private void printStick(int value) {
        for (int i = 0; i < value; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
