package validate;


import static constant.MagicNumbers.*;

import camp.nextstep.edu.missionutils.Randoms;

public class ValidateGo {
    private ValidateGo(){

    }

    private static int GoStopNumber;


    public static boolean validateGoStop() {
        GoStopNumber = Randoms.pickNumberInRange(RANDOM_MIN.getNumbers(), RANDOM_MAX.getNumbers());
        if ( NUM_CHECK_GO.getNumbers() <= GoStopNumber ){
            return true;
        }
        return false;
    }

}
