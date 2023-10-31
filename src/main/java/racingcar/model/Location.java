package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Location {

    private static final String INIT_LOCATION = "";
    private static final String ONE_STEP = "-";
    private String location;

    public Location() {
        this.location = INIT_LOCATION;
    }

    public void stopOrMove() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            location += ONE_STEP;
        }
    }

    @Override
    public String toString() {
        return location;
    }
}
