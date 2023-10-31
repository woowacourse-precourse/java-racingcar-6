package racingcar;

public class Exception {
    int checkNumberException(String number){
        try{
            return Integer.valueOf(number);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
