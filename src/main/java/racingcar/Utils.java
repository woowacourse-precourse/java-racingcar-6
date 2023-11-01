package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {

    public static int getMax(ArrayList<Integer> numbers) {
        return Collections.max(numbers);
    }

    public static ArrayList<String> toArrayList(String carNameInputs) {
        return new ArrayList<>(Arrays.asList(carNameInputs.split(Constants.DELIMITER)));
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_NUM, Constants.MAX_NUM);
    }

    public static String dashRepeat(int num) {
        StringBuilder dashes = new StringBuilder();
        IntStream.range(0, num).forEach(i -> dashes.append(Constants.DASH));
        return dashes.toString();
    }
}
