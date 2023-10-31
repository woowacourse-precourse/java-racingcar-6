package racingcar;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    public static void checkCarInput(String inputString) {
        checkEmpty(inputString);
        String[] splitInputData = inputString.split(",");
        checkSize(splitInputData);
        checkBlank(splitInputData);
        checkDuplication(splitInputData);
    }

    public static void checkRoundInput(String inputString) {
        checkEmpty(inputString);
        checkDigit(inputString);
        checkNaturalNumber(inputString);
    }

    private static void checkEmpty(String inputString) {
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("Error:입력이 비어있습니다.");
        }
    }

    private static void checkSize(String[] splitInputData) {
        for (int i = 0; i < splitInputData.length; i++) {
            if (splitInputData[i].length() > 5) {
                throw new IllegalArgumentException("Error:이름이 너무 깁니다.");
            }
        }
    }

    private static void checkBlank(String[] splitInputData) {
        for (int i = 0; i < splitInputData.length; i++) {
            if (splitInputData[i].isEmpty()) {
                throw new IllegalArgumentException("Error:이름이 없는 차가 있습니다.");
            }
            if (splitInputData[i].contains(" ")) {
                throw new IllegalArgumentException("Error:이름에 공백이 있습니다.");
            }
        }
    }

    private static void checkDuplication(String[] splitInputData) {
        HashSet<String> carNamesSet = new HashSet<String>(Arrays.asList(splitInputData));
        if (carNamesSet.size() != splitInputData.length) {
            throw new IllegalArgumentException("Error:이름에 중복이 있습니다.");
        }
    }

    private static void checkDigit(String InputData) {
        for (int i = 0; i < InputData.length(); i++) {
            if(!Character.isDigit(InputData.charAt(i))){
                throw new IllegalArgumentException("Error:숫자만 입력하세요");
            }
        }
        try{
            int inputNumber = Integer.parseInt(InputData);
        } catch (Exception e){
            throw new IllegalArgumentException("Error:정수만 입력하세요");
        }
    }

    private static void checkNaturalNumber(String InputData){
        int inputNumber = Integer.parseInt(InputData);
        if(inputNumber<1){
            throw new IllegalArgumentException("Error:1이상의 정수를 입력하세요");
        }
    }

}
