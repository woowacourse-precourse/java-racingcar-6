package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarMovement {
    private List<int[]> getRandomNumbers(int numberOfCars, int tryNumber) {
        List<int[]> randomNumbersPerCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            int[] randomNumbers = new int[tryNumber];
            for (int j = 0; j < tryNumber; j++) {
                randomNumbers[j] = Randoms.pickNumberInRange(0, 9);
            }
            randomNumbersPerCars.add(randomNumbers);
        }
        return randomNumbersPerCars;
    }

    private int getCarsMoveOrStop(int[] randomNumbers) {
        int result = 0;
        for (int randomNumber : randomNumbers) {
            if (randomNumber >= 4) {
                result++;
            }
        }
        return result;
    }

    public int[] getCarMoveCount(List<Object> racingData) {
        String[] carNames = (String[]) racingData.get(0);
        int numberOfCars = carNames.length;
        int tryNumber = (int) racingData.get(1);

        List<int[]> randomNumbersPerCars = getRandomNumbers(numberOfCars, tryNumber);

        int[] moveResults = new int[numberOfCars];

        for (int i = 0; i < numberOfCars; i++) {
            int[] randomNumbers = randomNumbersPerCars.get(i);
            int moveResult = getCarsMoveOrStop(randomNumbers);
            moveResults[i] = moveResult;
        }
        return moveResults;
    }
}
