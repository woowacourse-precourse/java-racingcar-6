package racingcar.domain.car;

import racingcar.domain.car.dto.RaceResult;
import racingcar.domain.random.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MOVE_STANDARD = 4;
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<RaceResult> play(List<Car> cars) {
        List<RaceResult> raceResults = new ArrayList<>();
        for (Car car : cars) {
            if (canMove(generateNum())) {
                car.move();
            }
            raceResults.add(new RaceResult(car.getName(), car.getPosition()));
        }

        return raceResults;
    }

    public List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private boolean canMove(int generateNum) {
        return generateNum >= MOVE_STANDARD;
    }

    private int generateNum() {
        return numberGenerator.generate();
    }

}
