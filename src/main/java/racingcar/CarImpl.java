package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarImpl implements Car {
    private int location = 0;

    @Override
    public void goOrStop(int min, int max) {
        int randNumber = pickNumberInRange(min, max);
        if (randNumber >= 4) {
            writeLocation();
        }
    }

    @Override
    public void writeLocation() {
        location++;
    }

    public int getLocation() {
        return location;
    }
}
