package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {

    public static List<String> isValidCarName(String input) {
        List<String> carList = Stream.of(input.split(",")).collect(Collectors.toList());

        isValidType(carList);
        isValidLength(carList);

        return carList;
    }

    // 자동차 이름들이 문자인지 검사
    private static void isValidType(List<String> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            try {
                Double.parseDouble(inputList.get(i));
                throw new IllegalArgumentException();
            } catch (NumberFormatException e) {}
        }
    }

    // 자동차 이름이 5자 이하인지 검사
    private static void isValidLength(List<String> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).length() > 5) {
                throw new IllegalStateException();
            }
        }
    }

    public static void main(String[] args) {
        String input = "pobiasdf,woni,jun!";
        isValidCarName(input);
    }
}
