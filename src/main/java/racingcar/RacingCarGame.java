package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final List<Car> cars;
    private final int targetPhase;

    public RacingCarGame(List<Car> cars, int targetPhase) {
        this.cars = cars;
        this.targetPhase = targetPhase;
    }

    public void start() {
        System.out.println(StringConstants.GAME_RESULT_MESSAGE);
        for (int t = 0; t < targetPhase; t++) {
            for (var car : cars) {
                car.go();
                System.out.println(car);
            }
            System.out.println();
        }
    }

    public void end() {
        Car max = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalArgumentException::new);
        List<String> winners = cars.stream()
                .filter(c -> c.compareTo(max) == 0).map(c -> c.getName())
                .collect(Collectors.toList());
        String message = String.join(", ", winners);
        System.out.print(StringConstants.FINAL_WINNER_MESSAGE + " : ");
        System.out.println(message);
    }
}
