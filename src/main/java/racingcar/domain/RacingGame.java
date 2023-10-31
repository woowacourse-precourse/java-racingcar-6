package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.Vars.MIN_RANDOM_NUMBER;
import static racingcar.Vars.MAX_RANDOM_NUMBER;


public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(String[] carNames, int rounds) {
        this.rounds = rounds;
        this.cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
    }

    public List<Car> playRound() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    public int getRounds() {
        return rounds;
    }
}
