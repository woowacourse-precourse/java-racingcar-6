package racingcar.random;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public static int randomNumberGenerator() {
        return Randoms.pickNumberInRange(0,9);
    }
}
