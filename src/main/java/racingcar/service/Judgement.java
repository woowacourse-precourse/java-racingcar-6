package racingcar.service;

import racingcar.domain.Car;

import java.util.*;

public class Judgement {

    public Judgement() {
    }

    public boolean isMovableRange(int random) {
        if (random >= 4) {
            return true;
        }

        return false;
    }

    public String findWinner(Car car) {
        Collection<Integer> movingList = car.getCarMoving();
        List<String> winner = new ArrayList<>();

        int maxMoving = movingList.stream()
                .max(Integer::compareTo)
                .orElse(0);

        Iterator<String> carNames = car.getCarName().iterator();

        while (carNames.hasNext()) {
            String carName = carNames.next();

            if (maxMoving == car.getMovingCount(carName)) {
                winner.add(carName);
            }
        }

        return String.join(", ", winner);
    }
}
