package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Refree {
    public boolean verifyPickNumber(int number) {
        if (number >= 4) {
            return true;
        }
        return false;
    }

}
