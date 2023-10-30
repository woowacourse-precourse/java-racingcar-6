package racingcar.varification;

public class Varification {
    public void checkNameLength(String[] carNameArray) {
        for (String name : carNameArray) {
            if (name.length()>5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void checkStringIsNum(String stringOfTimes) {
        try {
            int intOfTimes = Integer.parseInt(stringOfTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }
}
