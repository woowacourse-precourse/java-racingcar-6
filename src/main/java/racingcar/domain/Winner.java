package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public void car(List<String> carNames, List<String> progressResults) {
        int maxNum = checkMax(progressResults);
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
