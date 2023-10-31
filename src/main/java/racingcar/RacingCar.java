package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.validation.Validation;

public class RacingCar {

    private String name;
    private int position;
    private List<Integer> raceLog;

    public RacingCar(String name) {
        this.name = name;
        this.raceLog = new ArrayList<>();
        this.position = 0;
    }

    public boolean moveBy(int random) {
        if (Validation.isNumberInRange(random) && random > 4) {
            position++;
            return true;
        }
        return false;
    }

    public Integer getRaceLogBy(int round) {
        return raceLog.get(round);
    }

    public int getPosition() {
        return position;
    }

    // 테스트를 위해 추가
    @Override
    public String toString() {
        return "name : " + name;
    }
}
