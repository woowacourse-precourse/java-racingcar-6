package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.Generator;

public class GeneratorTest {
    private Generator generator;

    @BeforeEach
    void setUp() {
        generator = new Generator();
    }

    @Test
    void checkRandomNum() {
        int output = generator.generateRandomNumber();
        assertEquals((output >= 0 && output <= 9), true);
    }
}
