package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarMovement {
    private List<int[]> getRandomNumbers(int numberOfCars, int tryNumber) {
        List<int[]> randomNumbersPerRound = new ArrayList<>();
        for (int i = 0; i < tryNumber; i++) {
            int[] randomNumbers = new int[numberOfCars];
            for (int j = 0; j < numberOfCars; j++) {
                randomNumbers[j] = Randoms.pickNumberInRange(0, 9);
            }
            randomNumbersPerRound.add(randomNumbers);
        }
        return randomNumbersPerRound;
    }

    private boolean[] getCarsMoveOrStop(int[] randomNumbers) {
        boolean[] moveResults = new boolean[randomNumbers.length];
        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i] >= 4) {
                moveResults[i] = true;
            }
        }
        return moveResults;
    }

    public List<boolean[]> getCarMoveCount(List<Object> racingData) {
        String[] carNames = (String[]) racingData.get(0);
        int numberOfCars = carNames.length;
        int tryNumber = (int) racingData.get(1);

        List<int[]> randomNumbersPerRound = getRandomNumbers(numberOfCars, tryNumber);

        List<boolean[]> moveResults = new ArrayList<>();

        for (int i = 0; i < tryNumber; i++) {
            int[] randomNumbers = randomNumbersPerRound.get(i);
            boolean[] moveResult = getCarsMoveOrStop(randomNumbers);
            moveResults.add(moveResult);
        }
        return moveResults;
    }
}
