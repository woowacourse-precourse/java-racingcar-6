package racingcar.validator;

public class RoundCountValidator {

    public boolean validateInputGameRound(String inputRound) {
        int round = validateNotInteger(inputRound);
        validateNotPositive(round);
        return true;
    }
    private int validateNotInteger(String inputRound) {
        int round;
        try {
            round = Integer.parseInt(inputRound);
        }catch (Exception e) {
            throw new IllegalArgumentException("정수가 아닌 문자는 입력할 수 없습니다");
        }
        return round;
    }

    private void validateNotPositive(int round) {
        if(round <= 0) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요.");
        }
    }

}
