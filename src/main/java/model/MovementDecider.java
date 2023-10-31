package model;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Constants;

public class MovementDecider {
    private int getRandomInt(){
        return Randoms.pickNumberInRange(Constants.MIN_RANDOM_VALUE, Constants.MAX_RANDOM_VALUE);
    }

    private boolean isPossibleToMove(int randomValue){
        return randomValue >= Constants.MIN_VALUE_TO_MOVE;
    }
}
