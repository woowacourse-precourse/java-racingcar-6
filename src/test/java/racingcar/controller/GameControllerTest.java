package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GameControllerTest {

    private GameController gameController;
    private final InputStream systemIn = System.in;

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @BeforeEach
    void setUp() {
        gameController = new GameController();
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
        Console.close();
    }

    @Test
    void run() {
        //given
        String carNamesInput = "pobi,woni";
        String tryCountInput = "5";
        String input = carNamesInput + "\n" + tryCountInput + "\n";

        //when
        provideInput(input);

        //then
        Assertions.assertSimpleTest(() -> gameController.run());
    }

}