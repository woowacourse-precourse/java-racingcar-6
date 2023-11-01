package racingcar.domain;

public class Number {
    int number;
    public Number(String num) {
        validateSize(num);
        validateNumber(num);
        this.number = Integer.parseInt(num);
    }

    private void validateSize(String num) {
        if (num.length() > 1) {
            throw new IllegalArgumentException("0~9 사이 숫자를 입력해주세요!");
        }
    }

    private boolean isNumeric(String num) {
        if (num == null) {
            return false;
        }
        try {
            int number = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void validateNumber(String num) {
        if (!isNumeric(num)) {
            throw new IllegalArgumentException("숫자가 아닙니다!");
        }
    }
}