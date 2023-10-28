package racingcar.exception;

import java.util.List;

public class Validator {

    public static void validateCarName(String carName) {

        boolean isValidCarName = (carName.length()<=5)&&(carName.length()>0);
        if(!isValidCarName){
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이입니다.");
        }
    }

    public static void validateNumberOfCar(List<String> carNames) {

        if(carNames.size()<2){
            throw new IllegalArgumentException("2대 이상의 자동차가 레이스에 참여해야 합니다.");
        }
    }

    public static void validateTryCount(String tryCount) {

        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
