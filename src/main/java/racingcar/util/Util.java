package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Util {
    public List<String> splitStringToList(String cars) {
        return new ArrayList<>(Arrays.asList(cars.split(",")));
    }

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static String getDash(int position)
    {
        String dash ="";
        for(int i=0; i<position ;i++){
            dash +="-";
        }
        return dash;
    }


}
