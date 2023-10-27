package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generate {

    public Integer RandomNumber(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        System.out.println(randomNum);
        return randomNum;
    }
}
