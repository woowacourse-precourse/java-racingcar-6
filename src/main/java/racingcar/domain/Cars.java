package racingcar.domain;

import static racingcar.constant.Constants.EXCEPTION_SAME_NAME;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.service.RoundService;
import racingcar.util.RandomNumberImpl;
import racingcar.view.Output;

public class Cars {
    private final List<Car> cars;
    private final RoundService roundService;
    private final Output output;

    public Cars(List<Car> cars) {
        checkNameDuplication(cars);
        this.cars = cars;
        roundService = new RoundService(new RandomNumberImpl());
        output = new Output();
    }

    private void checkNameDuplication(List<Car> cars) {
        Set<String> nameList = new HashSet<>();
        cars.forEach(car -> {
            if (!nameList.add(car.getCarName())) {
                throw new IllegalArgumentException(EXCEPTION_SAME_NAME);
            }
        });
    }

    public void playOneRound() {
        roundService.moveCarsByRandom(this.cars);
    }

    public void printRoundResult() {
        output.printRoundResult(this.cars);
    }


    public List<Car> compareWinner() {
        int maxScore = cars.stream().mapToInt(Car::getPosition).max().orElseThrow();
        List<Car> winnerList = cars.stream().filter(car -> car.getPosition() == maxScore).toList();
        return new ArrayList<>(winnerList);
    }
}
