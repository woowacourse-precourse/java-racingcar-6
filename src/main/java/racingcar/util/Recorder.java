package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputMessage;

import java.util.List;

public class Recorder {
    OutputMessage outputMessage;
    List<String> car;
    int[] now;

    public int[] record(List<String> car, int lap) {
        this.car = car;
        now = makeRecord(car.size());
        while (lap < 0) {
            countRecord();
            printRecord();
            lap--;
        }
        return now;
    }

    public int[] makeRecord(int size) {
        return new int[size];
    }

    public void countRecord() {
        for (int i = 0; i < car.size(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                now[i]++;
            }
        }
    }

    public void printRecord() {
        for (int i = 0; i < car.size(); i++) {
            outputMessage.currentRecord(car.get(i), now[i]);
        }
        outputMessage.finishRecord();
    }
}
