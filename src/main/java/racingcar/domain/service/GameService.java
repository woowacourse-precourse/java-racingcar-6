package racingcar.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.model.Car;

import java.util.Collections;
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

    public void calculateWinnerCar(Car car) {
        List<String> names = car.getNames();
        Map<String, Integer> distance = car.getDistance();
        Integer maxDistance = Collections.max(distance.values());
        List<String> winners = names.stream()
                .filter(name -> distance.get(name) >= maxDistance)
                .toList();
        car.setWinners(winners);
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
