package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {
    static int[] Racing(List<String> Cars,int[] Cars_Distance){
        for(int car = 0; car < Cars.size(); car++){
            int random = Randoms.pickNumberInRange(0,9);
            if (random > 3)
                Cars_Distance[car]++;
        }
        for(int car = 0; car < Cars.size(); car++){
            System.out.println(Cars.get(car)+" : "+ "-".repeat(Cars_Distance[car]));

        }
        System.out.println();
        return Cars_Distance;
    }

}
