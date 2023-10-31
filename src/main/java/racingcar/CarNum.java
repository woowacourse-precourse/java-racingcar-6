package racingcar;

public class CarNum {
    private final static int MAX_CAR_NUM = 10;
    private int num;

    CarNum(String[] carNameParsing) {
        isValidCarNum(carNameParsing);
        this.num = carNameParsing.length;
    }

    private void isValidCarNum(String[] carNameParsing) throws IllegalArgumentException {
        if (carNameParsing.length > MAX_CAR_NUM) {
            throw new IllegalArgumentException("Error : 자동차 개수가 너무 많습니다 최대개수 " + MAX_CAR_NUM);
        }
        if (carNameParsing.length == 1 && carNameParsing[0].isBlank()) {
            throw new IllegalArgumentException("Error : 자동차 개수가 너무 적습니다 최소 하나라도 입력해 주세요");
        }
    }
}
