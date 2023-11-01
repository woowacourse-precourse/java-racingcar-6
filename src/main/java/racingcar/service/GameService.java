package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;
import java.util.Map;

public class GameService {
    public void handleCar(Car car) {
        List<String> names = car.getNames();
        Map<String, Integer> distance = car.getDistance();
        names.forEach(name -> {
            int number = generateRandomNumber();
            forwardOrStopAccordingToNumber(number, name, distance);
        });
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void forwardOrStopAccordingToNumber(int number, String name, Map<String, Integer> distance) {
        if (number >= 4) {
            distance.put(name, distance.get(name) + 1);
        }
    }
}
