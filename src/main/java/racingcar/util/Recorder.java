package racingcar.util;

import java.util.List;

public class Recorder {
    int[] now;
    public void record(List<String> car, int lap) {
        now = makeRecord(car.size());
        while (lap < 0) {

            lap--;
        }
    }

    public int[] makeRecord(int size) {
        return new int[size];
    }
}
