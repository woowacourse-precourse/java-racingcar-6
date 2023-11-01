package racingcar.domain;

public class Input {

    public static String[] carNamesToArray(String inputCarNames) {
        String[] carNamesArray = inputCarNames.split(",");
        carNamesInputException(carNamesArray);
        return carNamesArray;
    }

    public static void carNamesInputException(String[] carNamesArray) {
        for (String carName : carNamesArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("5자 이하의 이름을 입력하세요");
            }
        }
    }

    public static int inputCountToInt(String inputCount){
        try {
            int intCount = Integer.parseInt(inputCount);
            return intCount;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자를 입력하시오.");
        }
    }
}
