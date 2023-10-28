package racingcar.user;

public class Validator {
    public static final String isNum = "^[1-9][0-9]*$";
    public static final String correctName = "^[0-9ㄱ-ㅎ가-힇A-Za-z]{1,5}";
    protected void carNameCheck(String input){
        if(input.length()>5){
            throw new IllegalArgumentException();
        }
        if(!input.matches(correctName)){
            throw new IllegalArgumentException();
        }
    }
    protected void gameRoundCheck(String input){
        if(!input.matches(isNum)){
            throw new IllegalArgumentException();
        }
    }
}
