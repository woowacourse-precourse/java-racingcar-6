package racingcar.service;

public class Validation {

    public void validateCarName(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public void validateAttempts(String attempts){
        Integer attemptsInteger = null;
        try {
            attemptsInteger = Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 자연수로 적어주세요.");
        }
        if (attemptsInteger <= 0) {
            throw new IllegalArgumentException("시도 횟수는 자연수로 적어주세요.");
        }
    }
}
