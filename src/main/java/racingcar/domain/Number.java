package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {

    public static List<Integer> generateRandomNumber(int carNumbers) {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < carNumbers; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }

        return randomNumbers;
    }
}
