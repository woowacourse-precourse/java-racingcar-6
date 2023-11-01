package racingcar.validation;

public class InputValidator {
    public static void validateLength(String input, int limit){
        if(input.length() > limit){
            throw new IllegalArgumentException("제한 길이를 초과하였습니다.");
        }
    }

    public static void validateNull(String input){
        if(input.equals("") || input == null){
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public static void validateNumber(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }
}
