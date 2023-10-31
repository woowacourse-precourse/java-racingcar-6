package racingcar;

public class Validation {

    public void validateInput(String input) {
        //사용자의 입력이 "," 혹은 알파벳이 아니면 IllegalArgumentException 발생
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isAlphabetic(input.charAt(i)) && input.charAt(i) != ',') {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if(carNames[i].equals("")) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateLength(String[] carNames) {
        //자동차 이름이 5자를 넘어가면 IllegalArgumentException 발생
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

}
