package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public boolean checkCanMoveForwardIfSpeedIsExceedThreshold(){
        int randomSpeed = generateRandomSpeed();
        if (randomSpeed >= Config.FORWARD_THRESHOLD){
            return true;
        }
        return false;
    }
    protected int generateRandomSpeed(){
        int randomSpeed = Randoms.pickNumberInRange(Config.MINIMUM_VALUE,Config.MAXIMUM_VALUE);
        return randomSpeed;
    }
}
