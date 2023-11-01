package controller;

public class InputValidator {

    public static String[] exceptionHanding(String userInputName){
        String[] carNameArray = userInputName.split(",");
        validateCarNameLength(carNameArray);
        return carNameArray;
    }
    public static void validateCarNameLength(String[] carNameArray){
        for (String carName : carNameArray) {
            if (carName.length() > 5)
                throw new IllegalArgumentException("이름이 5글차를 초과했습니다.");
        }
    }
}
