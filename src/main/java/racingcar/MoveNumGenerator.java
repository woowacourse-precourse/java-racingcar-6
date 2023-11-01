package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveNumGenerator {

    private int startNum;
    private int endNum;

    public MoveNumGenerator(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public int generate() {
        return Randoms.pickNumberInRange(startNum, endNum);
    }
}
