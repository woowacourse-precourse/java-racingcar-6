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

    public int[] eliminate(int[] now, int max) {
        int[] result = new int[now.length];
        for (int i = 0; i < now.length; i++) {
            if (now[i] != max) {
                result[i] = 0;
            }
            result[i] = max;
        }
        return result;
    }
}
