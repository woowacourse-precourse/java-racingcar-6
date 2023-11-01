package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    static List<String>FindWinner(List<String> Cars,int[] Cars_Distance){
        int max = Cars_Distance[0];
        List<String> Winner = new ArrayList<String >();
        for(int car = 0; car < Cars.size(); car++) {
            if (Cars_Distance[car] > max)
                max = Cars_Distance[car];
        }

        for(int car = 0; car < Cars.size(); car++) {
            if(max == Cars_Distance[car])
                Winner.add(Cars.get(car));
        }
        return Winner;
    }
}
