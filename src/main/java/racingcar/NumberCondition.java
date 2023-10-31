package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Numbers {
    Map<Boolean, Integer> map = new HashMap<>();
    public Numbers() {
        map.put(true, 1);
        map.put(false, 0);
    }

    public int compareFour(int number) {return this.map.get(number >= 4);}
}
