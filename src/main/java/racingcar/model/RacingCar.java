package racingcar.model;

import java.util.Arrays;
import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.utils.Constants.*;

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

    // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    public void randomStepForward() {
        int random = Randoms.pickNumberInRange(ZERO, NINE);
        if(random >= RANDOM_MOVE_STANDARD) {
            this.distanceTraveled = this.distanceTraveled + 1;
        }
    }

    public String getScore() {
        char[] paths = new char[distanceTraveled];
        Arrays.fill(paths, DASH);
        return this.carName + " : " + String.join("", new String(paths));
    }
}
