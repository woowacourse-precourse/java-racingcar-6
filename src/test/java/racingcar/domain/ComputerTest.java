package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

class ComputerTest {
    @RepeatedTest(100)
    void createRandomNumberShouldReturnNumberInRange() {
        int randomNumber = Computer.createRandomNumber();

        assertTrue(randomNumber >= 0);
        assertTrue(randomNumber <= 9);
    }

}