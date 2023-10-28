package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.NumberGenerator;

public class RaceService {

    private static final NumberGenerator numberGenerator = new NumberGenerator();


    public void raceRoundGameStart(List<Car> cars) {
        for (Car car : cars) {
            if (numberGenerator.generate() >= 4)
                car.advance();
            String string = car.toString();
        }



    }
}
