package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {

    public static int getMax(ArrayList<Integer> numbers) {
        return Collections.max(numbers);
    }

    public static ArrayList<String> toArrayList(String carNameInputs) {
        return new ArrayList<>(Arrays.asList(carNameInputs.split(Constants.DELIMITER)));
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
