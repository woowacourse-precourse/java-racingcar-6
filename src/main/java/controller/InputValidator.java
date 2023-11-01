package controller;

public class InputValidator {

    public static String[] exceptionHanding(String userInputName){
        String[] carNameArray = userInputName.split(",");
        validateCarNameLength(carNameArray);
        checkIfInputExists(carNameArray);
        return carNameArray;
    }
    public static void validateCarNameLength(String[] carNameArray){
        for (String carName : carNameArray) {
            if (carName.length() > 5)
                throw new IllegalArgumentException("이름이 5글차를 초과했습니다.");
        }
    }
    public static void checkIfInputExists(String[] carNameArray) {
        for (String carName : carNameArray) {
            if (carName == null || carName.trim().isEmpty())
                throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    public static int numberHandlingException(String gameCount){
        isNotEmpty(gameCount);
        return isNumberic(gameCount);
    }


    public static int isNumberic(String gameCount) {
        try {
            int returnNumber = Integer.parseInt(gameCount);
            return returnNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }

    public static void isNotEmpty(String gameCount) {
        if (gameCount.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
    }

}

