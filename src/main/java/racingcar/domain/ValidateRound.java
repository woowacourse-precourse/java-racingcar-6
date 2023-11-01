package racingcar.domain;

public class ValidateRound {

    public void validateRound(String round) {
        try {
            Integer.parseInt(round);
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 형식이 아닙니다.");
        }
        if (Integer.parseInt(round) < 1) {
            throw new IllegalArgumentException("1이상의 수를 입력해 주세요.");
        }
    }
}
