package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;


public class CarService {
    // RandomNumberGenerator 만들기
    // Number 판별기 여기 혹은 Control에 만들기
    public static int generateRandomNumber() {
        int random = Randoms.pickNumberInRange(0,9);
        return random;
    }


}
