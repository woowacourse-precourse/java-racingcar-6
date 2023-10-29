package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultOutput {
    private List<String> strResults = new ArrayList<>();

    public void printRacingResult(String[] carNames, List<Boolean> boolResult) {
        List<String> strResult = boolResultToStr(boolResult);
        setStrResults(strResult);
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i] + " : " + strResults.get(i));
        }
        System.out.println();
    }

    private List<String> boolResultToStr(List<Boolean> boolResult) {
        List<String> strResult = new ArrayList<>();
        for (int i = 0; i < boolResult.size(); i++) {
            strResult.add("");
            if (boolResult.get(i)) {
                strResult.set(i, "-");
            }
        }
        return strResult;
    }

    private void setStrResults(List<String> strResult) {
        if (strResults.isEmpty()) {
            strResults = strResult;
            return;
        }
        for (int i = 0; i < strResult.size(); i++) {
            String addStrResult = strResults.get(i) + strResult.get(i);
            strResults.set(i, addStrResult);
        }
    }
}
