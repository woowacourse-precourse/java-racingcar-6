package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> generateRandomNumber(int n) {
        List<Integer> randomNumbers = new ArrayList<>();

        while(randomNumbers.size() < n) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }

        return randomNumbers;
    }
}
