package racingcar.service;

public class CheckTryNumber {

    public static int checkTryNumber(Integer inputNumber){
        if(!checkIsZero(inputNumber)){
            throw new IllegalArgumentException();
        }

        return inputNumber;
    }

    public static boolean checkIsZero(Integer inputNumber){
        if(inputNumber == 0){
            return false;
        }else{
            return true;
        }
    }
}
