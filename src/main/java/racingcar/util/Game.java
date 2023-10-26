package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    public int randomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
