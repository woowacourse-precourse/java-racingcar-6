package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winner {
    public static void findWinners(List<String> carList, int[] goCount){

        findMaxNumberAndToSaveIndexOfMaxNumber(goCount,carList);
    }
    public static void findMaxNumberAndToSaveIndexOfMaxNumber(int[] goCount,List<String> carList){
        int[] copyGoCount = new int[goCount.length];
        for(int i = 0 ; i < copyGoCount.length ; i++){
            copyGoCount[i]=goCount[i];
        }
        Arrays.sort(goCount);
        int maxNumber = goCount[goCount.length-1];

        List<Integer> indexOfMaxNumber = new ArrayList<>();
        for(int i = 0 ; i< copyGoCount.length;i++){
            if(copyGoCount[i]==maxNumber){
                indexOfMaxNumber.add(i);
            }
        }
        findWinnerCarByIndexOfMaxNumber(indexOfMaxNumber,carList);
    }


}
