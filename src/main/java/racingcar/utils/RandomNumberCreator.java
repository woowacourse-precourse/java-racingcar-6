package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberCreator {
    
    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static List<Integer> makeRandomNumbers(int numOfCars) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            randomNumbers.add(RandomNumberCreator.makeRandomNumber());
        }
        return randomNumbers;
    }
}
