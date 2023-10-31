package racingcar.model;

import static racingcar.utils.Constants.*;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    String carName;
    int distanceTraveled;


    public RacingCar(String givenCarName) {
        this.carName = givenCarName;
        this.distanceTraveled = ZERO;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public String getCarName() {
        return carName;
    }

    public void randomStepForward() {
        int random = Randoms.pickNumberInRange(ZERO, NINE);
        if(random >= RANDOM_MOVE_STANDARD) {
            this.distanceTraveled = this.distanceTraveled + 1;
        }
    }

    public String getScore() {
        String path = DASH.repeat(distanceTraveled);
        return this.carName + COLON + String.join("", path);
    }
}
