package racingcar.view.game;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class CarRaceGameTest {

    private final static Game CG = new CarRaceGame();

    @Test
    void startGame() {
        System.setIn(createUserInput("pobi,woni\n5"));
        CG.startGame();
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}