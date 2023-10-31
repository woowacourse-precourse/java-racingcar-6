package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Car movableCar1;
    Car movableCar2;
    Car immovableCar;
    Game game;
    static final int givenAttemptCount = 5;

    @BeforeEach
    void setUp() {
        movableCar1 = new Car("win1", () -> 4);
        movableCar2 = new Car("win2", () -> 4);
        immovableCar = new Car("loser", () -> 3);

        game = new Game(Arrays.asList(movableCar1, movableCar2, immovableCar), givenAttemptCount);
    }

    @Test
    @DisplayName("한 번 시행 후 position리스트 (1,1,0)")
    void 레이스_한번_시행() {
        game.carRaceOnce();
        Assertions.assertEquals(Arrays.asList(1,1,0),
                game.getCars().stream().map(Car::getPosition).toList());
    }

    @Test
    @DisplayName("모든 시행 후 isGameOver true반한")
    void 게임_끝_확인() {
        for (int i = 0; i < givenAttemptCount; i++) {
            game.carRaceOnce();
        }
        Assertions.assertTrue(game.isGameOver());
    }
}