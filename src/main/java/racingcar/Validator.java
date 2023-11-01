package racingcar;

import java.util.List;

public class Validator {
    private String userInput;
    private List<String> names;
    private void checkNameLength() throws IllegalStateException{
        for(String name: names){
            if(name.length() > 5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private boolean isNumeric(String c){
        try{
            Integer.parseInt(c);
            return true;
        } catch (NumberFormatException error){
            return false;
        }
    }
    private void isString(){
        for(int i=0;i<userInput.length();i++){
            if(isNumeric(userInput.substring(i, i+1))){
                throw new IllegalArgumentException("이름에 숫자가 들어갈 수 없습니다.");
            }
        }
    }

    public void validateUserinput(String input, List<String> carNames){
        userInput = input;
        isString();
        names = carNames;
        checkNameLength();
    }
}
