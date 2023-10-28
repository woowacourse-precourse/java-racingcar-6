package racingcar.service;

public class CheckService {

    private final static int NAME_LENGH_MAX = 5;
    private final static int NAME_LENGH_MIN = 1;

    public void cars(String[] cars) {
        for (String car : cars) {
            isTrim(car);
            isRange(car);
        }
    }

    public void nums(String num) {
        isDigit(num);
    }

    private void isRange(String car) {
        if (car.length() < NAME_LENGH_MIN || car.length() > NAME_LENGH_MAX) {
            throw new IllegalArgumentException("이름은 1~5글자 사이여야 합니다.");
        }
    }

    private void isTrim(String car) {
        if (!car.equals(car.trim())) {
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
