package racingcar.validator;

public class Validator {

    public static boolean validateLength(String input, int limitLength){
        if(input.length() > limitLength){
            throw new IllegalArgumentException("제한 길이를 초과하였습니다.");
        }
        return true;
    }

    public static boolean validateNull(String input){
        if(input.equals("") || input == null){
            throw new IllegalArgumentException("입력하지 않았습니다.");
        }
        return true;
    }

    public static boolean validNumberic(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
        return true;
    }
}
