package racingcar.validator;

public class CountValidator {

    public static void checkNumber(String Count){
        try{
            Integer.parseInt(Count);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
