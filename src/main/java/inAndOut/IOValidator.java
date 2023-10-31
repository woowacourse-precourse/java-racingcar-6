package inAndOut;

public class IOValidator {
    public static final String ERROR = "[ERROR]";
    public IOValidator() {
    }

    public String validateCarNames(String input) {
        checkIfEmpty(input);
        checkInputContainsComma(input);
        return input;

    }

    public void checkIfEmpty(String input) {
        if (input.isEmpty()) {
            throw new RuntimeException(ERROR + " 공백은 안돼! 입력을 확인해주세요.");
        }
    }

    public void checkInputContainsComma(String input) {
        if (!input.contains(",")) {
            throw new RuntimeException(ERROR + " ,을 활용하여 구분해주세요");
        }
    }

    public int validateCount(String input) {
        checkIfEmpty(input);
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new RuntimeException(ERROR + " 시도 횟수는 숫자여야합니다.");
            }
        }
        return Integer.parseInt(input);
    }

}
