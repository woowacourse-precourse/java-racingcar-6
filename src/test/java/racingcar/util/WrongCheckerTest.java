package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WrongCheckerTest {

    WrongChecker wrongChecker;

    @BeforeEach
    public void beforeEach() {
        wrongChecker = new WrongChecker();
    }

    @Test
    void hasWrongCarName() {
        //given
        String testString = "abc,def,figee,hheaagg,tyu";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.hasWrongCarName(testString);
        });
    }

    @Test
    void hasWrongAttemptNum() {
        //given
        String testString = "1234567890!";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.hasWrongAttemptNum(testString);
        });
    }
}