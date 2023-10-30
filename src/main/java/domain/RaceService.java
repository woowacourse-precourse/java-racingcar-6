package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceService {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public List<String> carNamesToList(String carNames) {
        String[] carNamesArr = carNames.split(",");
        return Arrays.asList(carNamesArr);
    }

    public void getResult(List<String> carNamesList, int[] result) {
        for (int j = 0; j < carNamesList.size(); j++) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (randomNumber >= 4) {
                result[j] += 1;
            }
        }
    }

    public Integer getMaxScore(List<String> carNamesList, int[] result) {
        int maxScore = -1;
        for (int i = 0; i < carNamesList.size(); i++) {
            if (result[i] > maxScore) {
                maxScore = result[i];
            }
        }
        return maxScore;
    }

    public List<String> getWinnerList(List<String> carNamesList, int[] result, int maxScore) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNamesList.size(); i++) {
            if (result[i] == maxScore) {
                winners.add(carNamesList.get(i));
            }
        }
        return winners;
    }
}
