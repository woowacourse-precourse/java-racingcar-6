package racingcar;

import java.util.List;

public class MaxIndexFinder {
    public int findMaxIndex(List<Integer> count){
        int index = 0;
        int size = count.size();
        for(int i = 0; i<size;i++){
            if(count.get(index) < count.get(i))
                index = i;
        }
        return index;
    }
}
