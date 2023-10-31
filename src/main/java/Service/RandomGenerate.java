package Service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerate {
    private final int minNum;
    private final int maxNum;

    public RandomGenerate(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
    }

    public int generate() {
        return Randoms.pickNumberInRange(minNum, maxNum);
    }
}
