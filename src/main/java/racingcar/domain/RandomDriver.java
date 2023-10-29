package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDriver implements Driver{
    public int getNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
