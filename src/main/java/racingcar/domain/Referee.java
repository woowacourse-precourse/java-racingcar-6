package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    protected Referee() {};

    public static List<String> calculateCars(String[][] names) {
        int maxNum = 0;
        List<String> result = new ArrayList<>();
        for(int i=0;i< names.length;i++) {
            maxNum = Math.max(maxNum, names[i][1].length());
        }
        for(int i=0;i< names.length;i++) {
            if(maxNum == names[i][1].length())
                result.add(names[i][0]);
        }
        return result;
    }
}
