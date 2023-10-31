package racingcar.validation;


public class InputValidation {

    public static void validateTriesInput(String input) {
        validateIsNumber(input);
        isExist(input);
    }

    private static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("값이 정수 범위를 초과했습니다.");
        }
    }

    private static void isExist(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요");
        }
    }
}
