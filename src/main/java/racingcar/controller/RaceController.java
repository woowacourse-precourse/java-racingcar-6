package racingcar.controller;

import racingcar.model.CarRepository;

public interface RaceController {

    void processRace(String round, CarRepository carRepository);

    void isValidInput(String input);

}
