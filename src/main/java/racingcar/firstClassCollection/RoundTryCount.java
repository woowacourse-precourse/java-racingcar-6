package racingcar.firstClassCollection;

public class RoundTryCount {
    private int count;

    public RoundTryCount(int roundTryCount) {
        checkValidRoundTryCount(roundTryCount);
        this.count = roundTryCount;
    }


    private void checkValidRoundTryCount(int count) {
        checkZero(count);
        checkNegativeNumber(count);
    }

    private void checkZero(int count) {
        if(count==0){
            throw new IllegalArgumentException("라운드가 0으로 입력됨");
        }
    }

    private void checkNegativeNumber(int count) {
        if(count<0){
            throw new IllegalArgumentException("라운드가 음수로 입력됨");
        }
    }


}
