package validate;


import static constant.MagicNumbers.*;

import camp.nextstep.edu.missionutils.Randoms;

public class ValidateGo {

    private int GoStopNumber = Randoms.pickNumberInRange(RANDOM_MIN.getNumbers(), RANDOM_MAX.getNumbers());


    public boolean ValidateGo() {
        if ( NUM_CHECK_GO.getNumbers() <= GoStopNumber ){
            return true;
        }
        return false;
    }

}
