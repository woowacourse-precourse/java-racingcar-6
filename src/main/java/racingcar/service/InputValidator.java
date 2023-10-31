package racingcar.service;

public class InputValidator {

    public boolean cars(String[] carsArr) {
        for (String car : carsArr) {
            isTrim(car);
        }
        return true;
    }

    public boolean nums(String num) {
        isTrim(num);
        isDigit(num);
        return true;
    }

    private void isTrim(String string) {
        if (!string.equals(string.trim())) {
            throw new IllegalArgumentException("공백이 포함되어 있습니다.");
        }
    }

    private void isDigit(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("횟수는 숫자여야 합니다.");
        }
    }
}