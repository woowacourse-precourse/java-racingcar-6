package racingcar;

import java.util.Arrays;

public class RacingCars {
    private final static int MAX_CAR_NUM = 10;
    private String[] parsedCarName;

    RacingCars(String inputCarNames) {
        isVaildRacingCars(inputCarNames);
        parsedCarName = inputCarNames.split(",");
    }

    void isVaildRacingCars(String inputCarNames) {
        validateRacingCarsBlank(inputCarNames);
        validateRacingCarsDuplicate(inputCarNames.split(","));
        validateRacingCarsRangeOver(inputCarNames.split(","));
        validateRacingCarsRangeUnder(inputCarNames.split(","));
    }

    String[] getCarName() {
        return (parsedCarName);
    }
    private void validateRacingCarsBlank(String inputCarName) throws IllegalArgumentException {
        if (inputCarName.matches(".*,,.*|.*,+$|^,.*")) {
            throw new IllegalArgumentException("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
        }
    }

    private void validateRacingCarsDuplicate(String[] parsedCarName) throws IllegalArgumentException {
        if (Arrays.stream(parsedCarName)
                .distinct()
                .count() != parsedCarName.length) {
            throw new IllegalArgumentException("Error : 중복된 자동차 이름이 있습니다 중복되지않게 입력해 주세요");
        }
    }

    private void validateRacingCarsRangeOver(String[] carNameParsing) throws IllegalArgumentException {
        if (carNameParsing.length > MAX_CAR_NUM) {
            throw new IllegalArgumentException("Error : 자동차 개수가 너무 많습니다 최대개수 " + MAX_CAR_NUM);
        }
    }

    private void validateRacingCarsRangeUnder(String[] carNameParsing) throws IllegalArgumentException {
        if (carNameParsing.length == 1 && carNameParsing[0].isBlank()) {
            throw new IllegalArgumentException("Error : 자동차 개수가 너무 적습니다 최소 하나라도 입력해 주세요");
        }
    }
}
