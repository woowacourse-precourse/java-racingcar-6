package racingcar;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    public static String[] checkCarInput(String inputString) {

        if (inputString.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] splitInputData = inputString.split(",");
        checkSize(splitInputData);
        checkBlank(splitInputData);
        checkDuplication(splitInputData);
    }

    private static void checkSize(String[] splitInputData) {
        for (int i = 0; i < splitInputData.length; i++) {
            if (splitInputData[i].length() > 5) {
                throw new IllegalArgumentException("이름이 너무 깁니다.");
            }
        }
    }

    private static void checkBlank(String[] splitInputData) {
        for (int i = 0; i < splitInputData.length; i++) {
            if (splitInputData[i].isEmpty()) {
                throw new IllegalArgumentException("이름이 없는 차가 있습니다.");
            }
            if (splitInputData[i].contains(" ")) {
                throw new IllegalArgumentException("이름에 공백이 있습니다.");
            }
        }
    }

    private static void checkDuplication(String[] splitInputData) {
        HashSet<String> carNamesSet = new HashSet<String>(Arrays.asList(splitInputData));
        if(carNamesSet.size() != splitInputData.length){
            throw new IllegalArgumentException("이름에 중복이 있습니다.");
        }
    }
}
