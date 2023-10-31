package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameService {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public List<Integer> generateRandomNumber(int carNumbers) {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < carNumbers; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }

        return randomNumbers;
    }
}
