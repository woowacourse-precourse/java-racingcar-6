package racingcar.domain;

import racingcar.utils.Constants;

public class TryCount {

    private final int count;

    public TryCount(String count) {
        validateCountIsNumber(count);
        validateCount(count);
        this.count = Integer.parseInt(count);
    }

    public void validateCountIsNumber(String count){
        if(!count.matches("^[0-9]*$")){
            throw new IllegalArgumentException(Constants.ERROR_TRY_COUNT_NUM);
        }
    }

    public void validateCount(String count){
        if(Integer.parseInt(count) < Constants.MIN_TRY_COUNT){
            throw new IllegalArgumentException(Constants.ERROR_TRY_COUNT_MIN);
        }
    }

    public int getCount() {
        return count;
    }
}
