package racingcar.service;

public class CheckService {

    private final static int NAME_LENGH_MAX = 5;
    private final static int NAME_LENGH_MIN = 1;

    public boolean cars(String[] carsArr) {
        for (String car : carsArr) {
            isTrim(car);
            isRange(car);
        }
        return true;
    }

    public boolean nums(String num) {
        isTrim(num);
        isDigit(num);
        return true;
    }

    private void isRange(String string) {
        if (string.length() < NAME_LENGH_MIN || string.length() > NAME_LENGH_MAX) {
            throw new IllegalArgumentException("이름은 1~5글자 사이여야 합니다.");
        }
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
