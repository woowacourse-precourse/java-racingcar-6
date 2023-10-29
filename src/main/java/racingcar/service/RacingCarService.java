package racingcar.service;

public class RacingCarService {
    private static final String DELIMITER = ",";

    public String[] splitRacingCarsByComma(String racingCars) {
        return racingCars.split(DELIMITER);
    }
}
