package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private NumberGenerator() {
    }

    public static List<Integer> numberGenerate(int carNumber)
    {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < carNumber; i++)
        {
            temp.add(Randoms.pickNumberInRange(0,9));
        }
        return temp;
    }
}
