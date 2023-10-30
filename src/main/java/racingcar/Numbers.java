package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Numbers {
    Map<Integer, Integer> map = new HashMap<>();
    public Numbers() {
        IntStream.range(0, 10).forEach(i -> {
            if (i < 4) map.put(i, 0);
            else map.put(i, 1);
        });
    }

    public int compareFour(int number) {return this.map.get(number);}
}
