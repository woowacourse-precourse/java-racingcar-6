package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public void car(List<String> carNames, List<String> progressResults) {
        List<String> winner = new ArrayList<>();
        int maxNum = checkMax(progressResults);

         for (int r = 0; r < progressResults.size(); r++) {
             if(progressResults.get(r).length() == maxNum) {
                 winner.add(carNames.get(r));
             }
         }
    }

    public int checkMax(List<String> progressResults) {
        int maxNum = 0;

        for (String progressResult: progressResults) {
            if(progressResult.length() > maxNum) {
                maxNum = progressResult.length();
            }
        }
        return maxNum;
    }
}
