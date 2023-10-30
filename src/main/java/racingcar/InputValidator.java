package racingcar;

public class InputValidator {

    public void validateLength(String input, int limitLength){
        if(input.length() > limitLength){
            throw new IllegalArgumentException("제한 길이를 초과하였습니다.");
        }
    }

    public void validateNull(String input){
        if(input.equals("") || input == null){
            throw new IllegalArgumentException("입력하지 않았습니다.");
        }
    }

    public void validNumberic(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }
}
