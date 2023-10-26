package racingcar.util;

public class Counter {
    public int maxCount(int[] now) {
        int temp = 0;
        for (int i : now) {
            if (temp < i) {
                temp = i;
            }
        }
        return temp;
    }
}
