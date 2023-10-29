package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public boolean checkCanMoveForwardIfSpeedIsExceedThreshold(){
        int randomSpeed = generateRandomSpeed();
        if (randomSpeed >= 4){
            return true;
        }
        return false;
    }
    protected int generateRandomSpeed(){
        int randomSpeed = Randoms.pickNumberInRange(0,9);
        return randomSpeed;
    }
}
