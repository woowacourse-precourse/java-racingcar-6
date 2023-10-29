package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Numbers {
    Map<Integer, Integer> map = new HashMap<>();
    public Numbers() {
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 1);
        map.put(5, 1);
        map.put(6, 1);
        map.put(7, 1);
        map.put(8, 1);
        map.put(9, 1);
    }

    public int compareFour(int number) {return this.map.get(number);}
}
