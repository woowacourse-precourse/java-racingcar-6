package racingcar.exception;

public class RoundException {

    public static int noIntRoundException(String strRound) {

        try {
            int round = Integer.parseInt(strRound);
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드는 숫자만 입력할 수 있습니다.");
        }
    }
}
