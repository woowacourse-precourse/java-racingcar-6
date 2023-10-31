package game;

public class NumOfAttempt {
    private final int num;

    public NumOfAttempt(String inputString) {
        int inputNum = validateNum(inputString);
        validatePositive(inputNum);
        this.num = inputNum;
    }

    private int validateNum(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("회수는 숫자만 입력해야합니다.");
        }
    }

    private void validatePositive(int inputNum) {
        if (inputNum <= 0) {
            throw new IllegalArgumentException("회수는 양수여야 합니다.");
        }
    }

    public int getNum() {
        return num;
    }
}
