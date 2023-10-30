package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarImpl implements Car {
    private int randNumber;
    private int location = 0;

    @Override
    public void goOrStop() {
        randNumber = pickNumberInRange(1, 9);
        if (randNumber > 4){
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
