package model;

import static util.ErrorMessages.TRY_CNT_NOT_NATURAL_NUMBER;
import static util.ErrorMessages.TRY_CNT_NOT_NUMBER;

/**
 * packageName    : model
 * fileName       : TryCount
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class TryCount {

    private final int tryCount;

    public boolean isNotSame(int tryCount) {
        return this.tryCount != tryCount;
    }

    public TryCount(String countString) {
        this.tryCount = convertStringToInt(countString);
        validatePositive(tryCount);
    }

    private int convertStringToInt(String countString){
        try {
            return Integer.parseInt(countString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_CNT_NOT_NUMBER);
        }
    }

    private void validatePositive(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(TRY_CNT_NOT_NATURAL_NUMBER);
        }
    }
}
