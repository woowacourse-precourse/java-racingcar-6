package random;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    private int start = 0;
    private int end = 9;

    public Random(){

    }
    public Random(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int create() {
        return Randoms.pickNumberInRange(start,end);
    }
}
