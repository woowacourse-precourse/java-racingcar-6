package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Judge {

    public int getMaximumNum(ArrayList<Integer> numList){
        return numList.stream()
                .mapToInt(x->x)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
