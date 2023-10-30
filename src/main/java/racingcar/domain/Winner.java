package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winner {
    public static void findWinners(List<String> carList, int[] goCount){

        findMaxNumberAndToSaveIndexOfMaxNumber(goCount,carList);
    }


}
