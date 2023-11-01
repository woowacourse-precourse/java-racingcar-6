package racingcar.utils;

public class CarValidator {


    public boolean validateCarName(String carName){
        if(isEnglish(carName) || isKorean(carName)){
            return true;
        }
        return false;
    }

    public boolean validateCarLength(String carLength){
        if (carLength.length() < 5) {
            return true;
        }
        return false;
    }

    public static boolean isEnglish(String input) {
        return input.matches("^[a-zA-Z]*$");
    }

    public static boolean isKorean(String input) {
        return input.matches("^[가-힣]*$");
    }
}
