package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayTest {

    private Play play;

    @BeforeEach
    void setUp(){
        play = new Play();
    }

    @Test
    void testVarifyCarNameLength() {
        String[] validNames = {"Car1", "Car2", "Car3"};
        String[] invalidNames = {"Car123", "45Car2"};

        // 유효한 이름 배열 테스트
        play.varifyCarNameLength(validNames);

        // 유효하지 않은 이름 배열 테스트
        assertThrows(IllegalArgumentException.class, ()->play.varifyCarNameLength(invalidNames));

    }

}
