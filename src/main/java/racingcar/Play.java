package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Play {

    public static boolean checkIFGoOrStop(int num) {
        //System.out.println(num);
        if (num < 4) {
            return false;
        }
        return true;
    }

    public static int makeRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static List<Integer> findEachCarRandomNum(int carLength) {
        List<Integer> randomNum = new ArrayList<>();

        for (int index=0; index<carLength; index++) {
            int tmpRandNum = makeRandomNum();
            if(checkIFGoOrStop(tmpRandNum)) {
                randomNum.add(index);
            }
        }
        return randomNum;
    }

}
