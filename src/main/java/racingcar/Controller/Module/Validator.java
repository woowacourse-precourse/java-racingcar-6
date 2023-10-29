package racingcar.Controller.Module;

public class Validator {
    public int validateInputIsNumber(int input){
        if(input > 0){
            return input;
        }else{
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }

    public Boolean validateNameInputContainsComma(String input){
        return input.contains(",");
    }
}
