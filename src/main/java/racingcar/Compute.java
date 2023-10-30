package racingcar;

import java.util.List;

public class Compute {

    public List<Integer> computeProgress(List<Integer> result, List<Integer> roundResult){

        int index = 0;
        for (Integer i : result) {
            if(i >= 4){
                roundResult.add(index,roundResult.get(index) + 1);
            }
            index++;
        }

        return roundResult;
    }
}
