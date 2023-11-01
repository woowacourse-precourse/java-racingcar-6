package racingcar.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.configuration.RandomNumberConfig.END_INCLUSIVE;
import static racingcar.configuration.RandomNumberConfig.START_INCLUSIVE;

public class RandomNumberGenerator {

    public static List<Integer> generateRandomNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            numbers.add(randomNumber);
        }

        return numbers;
    }

}