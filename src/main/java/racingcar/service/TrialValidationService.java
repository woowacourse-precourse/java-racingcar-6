package racingcar.service;

public class TrialValidationService {
    public void validateTrial(String input) {
        isBlank(input);
        isPositiveInteger(input);
    }
    private void isBlank(String input){
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백은 입력 불가");
        }
    }

    private void isPositiveInteger(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("양의 정수만 입력 가능");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능");
        }
    }
}
