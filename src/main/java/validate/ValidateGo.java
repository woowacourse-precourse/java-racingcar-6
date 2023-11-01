package validate;

import static constant.MagicNumbers.*;
import camp.nextstep.edu.missionutils.Randoms;

public class ValidateGo {

    private static int gostopnumber;

    private ValidateGo() {
    }

    public static boolean validateGoStop() {
        gostopnumber = Randoms.pickNumberInRange(RANDOM_MIN.getNumbers(), RANDOM_MAX.getNumbers());
        if (NUM_CHECK_GO.getNumbers() <= gostopnumber) {
            return true;
        }
        return false;
    }

}
