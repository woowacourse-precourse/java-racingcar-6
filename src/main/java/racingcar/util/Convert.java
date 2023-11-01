package racingcar.util;

public class Convert {
    public static int stringToInteger(String number){
        try{
            return Integer.parseInt(number);
        } catch (Exception e){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다." + e.getMessage());
        }
    }
}
