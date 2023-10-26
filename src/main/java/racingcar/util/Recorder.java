package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Recorder {
    int[] now;

    public void record(List<String> car, int lap) {
        now = makeRecord(car.size());
        while (lap < 0) {
            countRecord(car);
            lap--;
        }
    }

    public int[] makeRecord(int size) {
        return new int[size];
    }

    public void countRecord(List<String> car) {
        for (int i = 0; i < car.size(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                now[i]++;
            }
        }
    }
}
