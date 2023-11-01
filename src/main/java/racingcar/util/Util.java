package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Util {
    public static int getMax(ArrayList<Integer> integers){
        return Collections.max(integers);

    }

    public static ArrayList<String> toArrayList(String carsString) {
        return new ArrayList<>(Arrays.asList(carsString.split(Constant.DELIMITER)));
    }

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_NUM, Constant.MAX_RANDOM_NUM);
    }

    public static String dashRepeat(int num) {
        StringBuilder dashes = new StringBuilder();
        IntStream.range(0, num).forEach(i -> dashes.append(Constant.DASH));
        return dashes.toString();
    }

}
