package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

//랜덤 값은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용

public class RandomNumber {
    public int createRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber;
    }
}