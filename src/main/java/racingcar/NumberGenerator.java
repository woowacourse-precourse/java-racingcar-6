package racingcar;
import camp.nextstep.edu.missionutils.Randoms;


public class NumberGenerator {
    public int createNumber(){
        int num = Randoms.pickNumberInRange(0,9);
        return num;
    }

    public boolean compareBigger(int tagetNum, int compareNum) {
        //목표 수(tagetNum)보다 비교할 수(compareNum)이 크면 true
        numberChecker(tagetNum);
        numberChecker(compareNum);
        if (tagetNum < compareNum){return true;}
        return false;
    }

    public void numberChecker(int num){
        if (num<0) {
            throw new IllegalArgumentException("do not allowed negative numbers");
        }
        if (num>9) {
            throw new IllegalArgumentException("to big a number");
        }
    }
}
