package racingcar.random;

import camp.nextstep.edu.missionutils.Randoms;

public interface Random {
    public static int generate(){
        return Randoms.pickNumberInRange(0,9);
    }
}
