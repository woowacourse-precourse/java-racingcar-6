package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class NumberUtil {

    public static int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static int getMaximumNum(ArrayList<Integer> numList){
        return numList.stream()
                .mapToInt(x->x)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
