package racingcar.util;

public class InputValidation {
    private final static int MAX_NAME_LENGTH = 5;
    public static void checkNameLength(String name) throws IllegalArgumentException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5자를 넘을 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름이 없는 차가 존재합니다.");
        }
    }

    public static void checkRaceRoundInput(String rounds) throws IllegalArgumentException {
        int roundNum = checkInputIsNum(rounds);
        checkInputIsOverZero(roundNum);
    }

    private static int checkInputIsNum(String input) throws IllegalArgumentException {
        try {
            int roundNum = Integer.parseInt(input);
            return roundNum;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("라운드 수가 숫자로 입력되지 않았습니다.");
        }
    }

    private static void checkInputIsOverZero(int input) throws IllegalArgumentException {
        if (input < 1)
            throw new IllegalArgumentException("라운드 수는 양수여야 합니다.");
    }
}
