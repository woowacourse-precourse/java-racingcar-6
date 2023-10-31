package racingcar.utils;

public class InputValidator {

    public int number(String numString){
        Integer number = validateNum(numString);
        return number;
    }

    public String cars(String carStr) {
        String[] carNames = carStr.split(",");
        for (String name:
             carNames) {
            validateCars(name);

        }
        return carStr;
    }

    private static void validateCars(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("너무 긴 이름를 입력했습니다.");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("잘못된 이름을 입력했습니다.");
        }
        if (name.charAt(0) == ' ') {
            throw new IllegalArgumentException("잘못된 이름을 입력했습니다.");
        }
    }


    private static Integer validateNum(String numString) {
        Integer number = null;
        try {
            number = Integer.parseInt(numString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 수 입력");
        }
        return number;
    }

}
