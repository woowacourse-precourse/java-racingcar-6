package racingcar;

public class CheckInput {
    // 공백 검사
    public void isBlank(String str) {
        if (str.contains(" ")) {
            throw new IllegalArgumentException("공백을 제거해주세요");
        }
    }

    public void lenCheck(String[] carsName) {
        for (String s : carsName) {
            if (s.isEmpty() || s.length() > 5) {
                throw new IllegalArgumentException("1~5길이의 이름을 입력해주세요");
            }
        }
    }

    public int isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(str);
    }

    public void isPositiveNum(String str) {
        if (Integer.parseInt(str) < 0) {
            throw new IllegalArgumentException("양수를 입력해주세요");
        }
    }
}
