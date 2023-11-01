package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.configs.Config;

public class Car {

    public boolean checkCarSpeedIsExceedThreshold(){
        int randomSpeed = generateRandomSpeed();
        if (randomSpeed >= Config.FORWARD_THRESHOLD){
            return true;
        }
        return false;
    }
    public int generateRandomSpeed(){
        int randomSpeed = Randoms.pickNumberInRange(Config.MINIMUM_VALUE,Config.MAXIMUM_VALUE);
        return randomSpeed;
    }
}
