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

    public static void checkNegativeNumber(int countNumber){
        if (countNumber < 0){
            throw new IllegalArgumentException();
        }
    }
}
