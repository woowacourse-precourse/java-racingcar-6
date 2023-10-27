package racingcar.Util;

import java.util.List;

public class Compare {

    public static List<Integer> numberCompare(List<Integer> carListCount, List<Integer> goAndStop) {
        increaseGoAndStopCount(carListCount,goAndStop);
        return goAndStop;
    }

    private static void increaseGoAndStopCount(List<Integer> carListCount, List<Integer> goAndStop) {
        for (int i = 0; i <goAndStop.size() ; i++) {
            if(carListCount.get(i)>3){
                goAndStop.set(i,goAndStop.get(i)+1);
            }
        }
    }
}