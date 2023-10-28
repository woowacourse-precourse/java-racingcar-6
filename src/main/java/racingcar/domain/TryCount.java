package racingcar.domain;

public class TryCount {
    private int tryCount;
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "올바를 숫자 형식을 입력해야합니다.";
    private static final String NUMBER_PARSE_ERROR_MESSAGE = "시도 횟수는 최소 1이상으로 입력해야합니다.";
    private static final int MINIMUM_TRY_COUNT = 1;

    public TryCount(String tryCount){
        validateParse(tryCount);
        int parsedCount = Integer.parseInt(tryCount);
        validateRange(parsedCount);
        this.tryCount = parsedCount;
    }

    private void validateParse(String tryCount){
        try{
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private void validateRange(int tryCount){
        if(tryCount < MINIMUM_TRY_COUNT){
            throw new IllegalArgumentException(NUMBER_PARSE_ERROR_MESSAGE);
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
