package racingcar.domain;

public class Input {
    public static String[] CarNamesToArray(String inputCarNames) {
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
}
