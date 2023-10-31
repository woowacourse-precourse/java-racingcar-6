package racingcar.utils;

public class Validation {
    public Integer validTryCount(Integer tryCount){
        if (tryCount < 1){
            throw new IllegalArgumentException("시도할 회수는 1이상이어야 합니다.");
        }
        return tryCount;
    }
}
