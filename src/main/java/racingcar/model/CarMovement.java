package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovement {

    private static int createRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        return randomNumber;
    }
}
