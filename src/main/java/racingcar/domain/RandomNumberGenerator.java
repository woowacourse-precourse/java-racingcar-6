package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.RaceConstant;

public class RandomNumberGenerator {
    public List<Integer> generateRandomNumbers(int numberCount){
        List<Integer> randomNumbers = new ArrayList<>();
        for (int tempCount = 0; tempCount < numberCount; tempCount ++) {
            int randomNumber = generateRandomNumber();
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(RaceConstant.MIN_NUMBER, RaceConstant.MAX_NUMBER);
    }
}
