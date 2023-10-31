package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Forward {
    public int random_num;
    private int START = 0;
    private int END = 9;

    public Forward() {
        random_num = Randoms.pickNumberInRange(START, END);
    }

    public int get_Num() {
        return this.random_num;
    }
}
