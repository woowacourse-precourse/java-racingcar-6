package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarMovement {
    private List<int[]> getRandomNumbers(int numberOfCars, int tryNumer) {
        List<int[]> randomNumbersPerCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            int[] randomNumbers = new int[tryNumer];
            for (int j = 0; j < tryNumer; j++) {
                randomNumbers[j] = Randoms.pickNumberInRange(0,10);
            }
            randomNumbersPerCars.add(randomNumbers);
        }
        return randomNumbersPerCars;
    }


}