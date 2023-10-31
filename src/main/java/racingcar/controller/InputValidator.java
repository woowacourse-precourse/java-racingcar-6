package racingcar.controller;

public class InputValidator {

    public void validateSingleNumber(String givenInput) {
        try {
            Integer.parseInt(givenInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자가 아닙니다.");
        }
    }
    public void validateNamesByDelimiter(String givenInput, String delimiter) {
        String[] parts = givenInput.split(delimiter);
        for (String part : parts) {
            if (!part.matches("[a-zA-Z가-힣]+")) {
                throw new IllegalArgumentException("delimiter를 제외한 부분에 특수 문자가 포함되어 있습니다.");
            }
        }
    }

}
