package racingcar.Util;

public class CheckNumberException {
    public static void numberValidation(String TryNumber){
        numberCheck(TryNumber);
        underPositiveNumber(TryNumber);
        tryNumberisEmpty(TryNumber);
    }
    public static void numberCheck(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("숫자값을 입력해주세요");
        }
    }
    public static void underPositiveNumber(String input){
        if(Integer.parseInt(input)<= 0){
            throw new IllegalArgumentException("0보다 큰 값을 입력해주세요");
        }
    }
    private static void tryNumberisEmpty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("값을 입력해 주세요");
        }
    }


}
