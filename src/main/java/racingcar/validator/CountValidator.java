package racingcar.validator;

public class CountValidator {

    public static int checkNumber(String count){
        int countNumber;
        try{
            countNumber = Integer.parseInt(count);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        return countNumber;
    }
}
