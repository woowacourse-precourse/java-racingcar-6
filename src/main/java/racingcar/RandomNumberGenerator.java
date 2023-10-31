package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class RandomNumberGenerator {
    public RandomNumberGenerator() {
    }

    public static List<Integer> setRandomNum(int car_num) {
        List<Integer> randomNum = new ArrayList<>();

        while(randomNum.size() < car_num) {
            int rnum = Randoms.pickNumberInRange(0, 9);
            randomNum.add(rnum);
        }
        return randomNum;
    }
}
