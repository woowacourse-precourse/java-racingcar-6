package racingcar;

import racingcar.service.CarRacingService;

public class Application {
    public static void main(String[] args) {
        CarRacingService carRacingService = new CarRacingService();
        carRacingService.racingStart();
    }
}
