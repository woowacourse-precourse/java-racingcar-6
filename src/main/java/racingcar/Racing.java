package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    Compute compute = new Compute();
    public List<Integer> racing(int i, List<Integer> roundResult){
        List<Integer> number = new ArrayList<>();
        for(int j = 0 ; j < i ; j++){
            number.add(Randoms.pickNumberInRange(0,9));
        }

        return compute.computeProgress(number, roundResult);
    }

}
