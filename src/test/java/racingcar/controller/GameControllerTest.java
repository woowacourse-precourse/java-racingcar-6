package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameControllerTest {


    @Test
    void playGame_자동차_경주_게임_성공() {
        GameController gameController = new GameController();
        assertDoesNotThrow(() -> gameController.playGame("pobi", 1));
    }

    @ParameterizedTest
    @MethodSource("playGame_자동차_경주_게임_검증시도_실패한다")
    void playGame_자동차_경주_게임_검증시도_실패한다(String carNamesInput, String numberOfAttempts) {
        GameController gameController = new GameController();
        assertThatThrownBy(() -> gameController.playGame(carNamesInput, Integer.parseInt(numberOfAttempts)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> playGame_자동차_경주_게임_검증시도_실패한다() {
        return Stream.of(
            Arguments.of("pobi", ""),
            Arguments.of("pobi", "crong")
        );
    }
}
