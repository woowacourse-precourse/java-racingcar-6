package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {
    List<Integer> randomNumbers = new ArrayList<>();
    int randomNumber;

    public List<Integer> random(int size) {
        for (int i = 0; i < size; i++) {
            randomNumber = Randoms.pickNumberInRange(0, 9);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
