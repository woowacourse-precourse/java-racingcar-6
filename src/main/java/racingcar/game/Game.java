package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.game.constant.StringConstants;
import racingcar.game.domain.Car;
import racingcar.game.domain.RandomizedCarEngine;
import racingcar.io.Input;

public interface Game {
    default void awake() {
    }

    /**
     * executed by {@link GameManager} before each game loop
     *
     * @return : true if start gameLoop()
     */
    default boolean beforeLoop() {
        return true;
    }

    /**
     * @return : true if continue loop
     */
    default boolean gameLoop() {
        return false;
    }

    /**
     * executed by {@link GameManager} after each game loop
     *
     * @return : true if restart
     */
    default boolean afterLoop() {
        return false;
    }

    default void cleanup() {
    }

    class RacingCarGame implements Game {
        private int targetPhase;
        private List<Car> cars;

        @Override
        public boolean beforeLoop() {
            var players = Input.inputPlayers();

            this.cars = players.stream()
                    .map(player -> new Car(
                            player,
                            new RandomizedCarEngine()
                    ))
                    .collect(Collectors.toList());
            this.targetPhase = Input.inputGamePhase();

            return true;
        }

        @Override
        public boolean gameLoop() {
            System.out.println(StringConstants.GAME_RESULT_MESSAGE);
            for (int t = 0; t < targetPhase; t++) {
                for (var car : cars) {
                    car.go();
                    System.out.println(car);
                }
                System.out.println();
            }
            return false;
        }

        @Override
        public boolean afterLoop() {
            Car max = cars.stream()
                    .max(Car::compareTo)
                    .orElseThrow(IllegalArgumentException::new);
            List<String> winners = cars.stream()
                    .filter(c -> c.compareTo(max) == 0).map(c -> c.getName())
                    .collect(Collectors.toList());
            String message = String.join(", ", winners);
            System.out.print(StringConstants.FINAL_WINNER_MESSAGE + " : ");
            System.out.println(message);
            return false;
        }

    }
}
