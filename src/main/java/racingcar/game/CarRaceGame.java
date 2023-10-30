package racingcar.game;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.CarRaceService;
import racingcar.validate.Validate;

public class CarRaceGame implements Game {
    private CarRaceService service;
    private int gameRound;

    public CarRaceGame() {
        this.service = new CarRaceService();
        this.gameRound = 0;
    }

    @Override
    public void startGame() {

    }

    private void saveRaceRound(String input) {
        Validate.isNumber(input);
        this.gameRound = Integer.parseInt(input);
    }



}
