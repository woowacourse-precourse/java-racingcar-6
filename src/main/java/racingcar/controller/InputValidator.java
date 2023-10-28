package racingcar.controller;

public class InputValidator {

    public static String[] nameValidation(String input_name) {

        if (input_name.isEmpty()) { //빈 배열이 입력되었을 경우
            throw new IllegalArgumentException("Invalid argument: empty names");
        }

        String[] names = input_name.split(",");

        if (names.length == 0) { // 쉼표만 입력되었을 경우
            throw new IllegalArgumentException("Invalid argument: empty names");
        }

        for (String name : names) {
            if (name.length() > 5) { // 이름의 길이가 5를 넘을 경우
                throw new IllegalArgumentException("Invalid argument: " + name);
            }
        }

        return names;

    }

    public static int numberValidation(String input_number) {

        int number;
        try { // 숫자가 아닌 입력을 받았을 경우
            number = Integer.parseInt(input_number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid argument: " + input_number);
        }
        if (number < 0) { // 음수를 입력 받았을 경우
            throw new IllegalArgumentException("Invalid argument: " + number);
        }

        return number;

    }

}
