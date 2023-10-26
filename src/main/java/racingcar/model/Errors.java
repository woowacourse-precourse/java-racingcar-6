package racingcar.model;

public class Errors {
    public static void nameInputThrowError (String names) throws IllegalArgumentException {
        String[] splitNames = names.split(",");
        for(int i = 0; i < splitNames.length; i++) {
            if(splitNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 입력 가능합니다.");
            }
        }
    }

    public static void numberInputThrowError (String number) throws IllegalArgumentException {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("진행할 회수는 숫자만 입력 가능합니다.");
        }
    }
}
