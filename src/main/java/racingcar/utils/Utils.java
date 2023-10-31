package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER_ = 9;

    public static List<String> splitAndToList(String carNames) {
        List<String> separatedCarNames = Arrays.stream(carNames.split("\\s*,\\s*"))
                                               .collect(Collectors.toList());
        return separatedCarNames;
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER_);
    }
}
