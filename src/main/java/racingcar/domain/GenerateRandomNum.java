package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNum {
    // 0~9 까지의 정중 하나를 반환하는 기능
    public int createRandomNum() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
