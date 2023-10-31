package racingcar;

public class IllegalException {
    public static void illegalException(String input){
        try{
            int intInput = Integer.parseInt(input);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
    public static void illegalException(String[] inputArr){
        for(String test : inputArr){
            if(test.length()>5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }
}