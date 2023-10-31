package domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public boolean randomNum(){
        int num = Randoms.pickNumberInRange(0,9);
        if (num>=4){
            return true;
        }else {
            return false;
        }
    }
}
