package racingcar.validator;

public class CountValidator {

    private static final String NOT_NUMBER = "숫자가 아닙니다.";
    private static final String IS_NEGATIVE_NUMBER = "0이상 입력해주세요.";

    public static int checkNumber(String count){
        int countNumber;
        try{
            countNumber = Integer.parseInt(count);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER);
        }

        return countNumber;
    }

    public static void checkNegativeNumber(int countNumber){
        if (countNumber < 0){
            throw new IllegalArgumentException(IS_NEGATIVE_NUMBER);
        }
    }
}
