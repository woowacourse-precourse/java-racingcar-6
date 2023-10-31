package racingcar;

public class TryCount {
    Integer tryCount;
    public TryCount(String tryCount){
        validationInteger(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
        validationPositiveInteger(this.tryCount);
    }

    public final void validationInteger(String tryCount) {
        try{
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 시도 횟수가 0보다 작거나 같으면 예외 발생
    public final void validationPositiveInteger(Integer tryCount){
        if(tryCount <= 0)
            throw new IllegalArgumentException();
    }

    public final Integer getTryCount(){
        return this.tryCount;
    }

}
