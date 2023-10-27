package racingcar.Controller;

import racingcar.Model.CarRepository;

public interface RaceController {

    void process(String round, CarRepository carRepository);

}
