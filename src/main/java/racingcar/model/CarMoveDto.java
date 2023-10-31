package racingcar.model;

import racingcar.constant.Constants;

public class CarMoveDto {
    public boolean isMove(){
        int randomNumber= camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0,9);
        return randomNumber>= Constants.RANDOM_NUMBER;
    }
}
