package model;

import utils.Utils;

public class TryCount {
    final static String NOT_NUMBER = "시도 횟수는 0 이상의 정수이어야 합니다.";
    final static String NEGATIVE_NUMBER = "시도 횟수는 음수가 될 수 없습니다.";
    int count;

    public TryCount(String input) {
        isNumber(input);
        isPositiveNumber(input);
        count = Utils.convertStringToInt(input);
    }

    public int getCount(){
        return count;
    }

    public void isNumber(String tryCount) {
        try {
            Utils.convertStringToInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public void isPositiveNumber(String input) {
        if (Utils.convertStringToInt(input) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }
}
