package racingcar.exception;

public class InputException {

    public static void checkInputLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("5자리 이하의 이름을 입력해야 합니다.");
        }
    }

    public static void checkTrialCountValid(String input) {
        try{
            int number = Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
