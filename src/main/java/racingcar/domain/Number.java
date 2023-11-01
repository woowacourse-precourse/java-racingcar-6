package racingcar.domain;

public class Number {
    int number;
    public Number(String num) {
        validateSize(num);
        validateNumber(num);
        this.number = Integer.parseInt(num);
    }

    private void validateSize(String num) {
        if (num.length() > 2) {
            throw new IllegalArgumentException("0~9 사이 숫자를 입력해주세요!");
        }
    }

    private void validateNumber(String num) {
        try {
            int number = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다!");
        }
    }
}