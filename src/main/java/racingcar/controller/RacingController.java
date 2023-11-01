package racingcar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.model.Information;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.model.RandomNumberGenerator;
import racingcar.util.Constants;

public class RacingController {
    public final RacingCars racingCars;
    public final int times;

    public RacingController(Information information) {
        racingCars = init(information.getNames());
        this.times = information.getTimes();
    }

    private RacingCars init(List<String> names) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(RacingCar.from(name));
        }
        return RacingCars.from(racingCars);
    }

    public void go() {
        for (RacingCar car : racingCars.getRacingCars()) {
            car.move(new RandomNumberGenerator());
        }
    }

    public List<RacingCar> getMaxs() {
        int max = Constants.RANDOM_NUM_START;
        HashMap<Integer, List<RacingCar>> map = new HashMap<>();

        for (RacingCar car : racingCars.getRacingCars()) {
            max = Math.max(car.getDistance(), max);
            if (map.containsKey(car.getDistance())) {
                List<RacingCar> values = map.get(car.getDistance());
                values.add(car);
                map.put(car.getDistance(), values);
                continue;
            }
            List<RacingCar> values = new ArrayList<>();
            values.add(car);
            map.put(car.getDistance(), values);
        }
        return map.get(max);
    }
}
