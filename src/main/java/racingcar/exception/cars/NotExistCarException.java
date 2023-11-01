package racingcar.exception.cars;

public class NotExistCarException extends IllegalArgumentException {

    public NotExistCarException() {
        super("현재 자동차 경주 게임에 자동차가 존재하지 않습니다.");
    }
}
