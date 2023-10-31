package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public List<Integer> createRandomNumbers(int carNumber) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
