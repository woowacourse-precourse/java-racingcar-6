package racingcar;

public class Errors {

    public static void namingError(String userInput) {
        if(userInput.length() < 1 || userInput.isBlank()) {
            throw new IllegalArgumentException("Error: 자동차의 이름을 설정하지 않으셨습니다.");
        }

        String[] words = userInput.replaceAll("\\s", "").split(",");

        for(int i = 0; i < words.length; i++) {
            if (words[i].length() > 5 || words[i].length() < 1) {
                System.out.println("Error: 5자 이하의 이름으로 입력하십시오.");
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals(words[i+1])) {
                System.out.println("Error: 중복된 이름입니다. 서로 다른 이름으로 입력하십시오.");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void inputWrongNumberError(String userInputNumber) {
        try {
            Integer.parseInt(userInputNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error: 숫자만 입력 가능합니다.");
        }

        if(userInputNumber.isBlank()) {
            throw new IllegalArgumentException("Error: 숫자만 입력 가능합니다.");
        }
    }

    public static void inputNegativeNumberError(int userInputTrialNumber) {
        if(userInputTrialNumber < 0) {
            throw new IllegalArgumentException("Error: 음수는 입력 불가합니다.");
        }
    }

    public static void inputZeroError(int userInputTrialNumber) {
        if(userInputTrialNumber == 0) {
            throw new IllegalArgumentException("Error: 1이상의 숫자를 입력해주십시오.");
        }
    }

}